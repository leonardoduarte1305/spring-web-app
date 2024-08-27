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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@EnableJpaRepositories(
        basePackages = {"dev.leoduarte.springwebapp.datasource2"},
        entityManagerFactoryRef = "mysql2LocalContainerEntityManagerFactoryBean",
        transactionManagerRef = "mysql2JpaTransactionManager"
)
@Configuration
@EnableConfigurationProperties
public class DatasourceMysql2 {

    private static final String PACKAGE_TO_SCAN = "dev.leoduarte.springwebapp.datasource2";

    @Bean
    @ConfigurationProperties("spring.datasourcemysql2.jpa")
    public Properties mysql2Properties() {
        return new Properties();
    }

    @Bean
    @ConfigurationProperties("spring.datasourcemysql2.datasource")
    public DataSourceProperties mysql2DataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasourcemysql2.hikari")
    public HikariConfig mysql2HikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource mysql2HikariDataSource(
            @Qualifier("mysql2DataSourceProperties")
            DataSourceProperties properties,
            @Qualifier("mysql2HikariConfig")
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
    public LocalContainerEntityManagerFactoryBean mysql2LocalContainerEntityManagerFactoryBean(
            @Qualifier("mysql2HikariDataSource")
            DataSource mysql2HikariDataSource,
            @Qualifier("mysql2Properties")
            Properties properties) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(mysql2HikariDataSource);
        emf.setPackagesToScan(PACKAGE_TO_SCAN);
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        emf.setJpaProperties(properties);
        return emf;
    }

    @Bean
    public JpaTransactionManager mysql2JpaTransactionManager(
            @Qualifier("mysql2LocalContainerEntityManagerFactoryBean")
            EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}
