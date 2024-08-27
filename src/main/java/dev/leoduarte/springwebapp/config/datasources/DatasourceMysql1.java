package dev.leoduarte.springwebapp.config.datasources;

import com.zaxxer.hikari.HikariConfig;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@EnableJpaRepositories(
        basePackages = {"dev.leoduarte.springwebapp.datasource1"},
        entityManagerFactoryRef = "mysql1LocalContainerEntityManagerFactoryBean",
        transactionManagerRef = "mysql1JpaTransactionManager"
)
@Configuration
@EnableConfigurationProperties
public class DatasourceMysql1 {

    private static final String PACKAGE_TO_SCAN = "dev.leoduarte.springwebapp.datasource1";

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasourcemysql1.jpa")
    public Properties mysql1Properties() {
        return new Properties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasourcemysql1.datasource")
    public DataSourceProperties mysql1DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary
    @ConfigurationProperties("spring.datasourcemysql1.hikari")
    public HikariConfig mysql1HikariConfig() {
        return new HikariConfig();
    }

    @Bean
    @Primary
    public DataSource mysql1HikariDataSource(
            @Qualifier("mysql1DataSourceProperties")
            DataSourceProperties properties,
            @Qualifier("mysql1HikariConfig")
            HikariConfig hikariConfig) {
        return DataSourceBuilder
                .create()
                .url(properties.getUrl())
                .username(properties.getUsername())
                .password(properties.getPassword())
                .driverClassName(hikariConfig.getDriverClassName())
                .build();
    }

    @Bean
    @Primary
    public LocalContainerEntityManagerFactoryBean mysql1LocalContainerEntityManagerFactoryBean(
            @Qualifier("mysql1HikariDataSource")
            DataSource mysql1HikariDataSource,
            @Qualifier("mysql1Properties")
            Properties properties) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(mysql1HikariDataSource);
        emf.setPackagesToScan(PACKAGE_TO_SCAN);
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        emf.setJpaProperties(properties);
        return emf;
    }

    @Bean
    @Primary
    public JpaTransactionManager mysql1JpaTransactionManager(
            @Qualifier("mysql1LocalContainerEntityManagerFactoryBean")
            EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
