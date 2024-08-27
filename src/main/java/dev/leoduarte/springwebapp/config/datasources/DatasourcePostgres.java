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
        basePackages = {"dev.leoduarte.springwebapp.datasource3"},
        entityManagerFactoryRef = "postgresLocalContainerEntityManagerFactoryBean",
        transactionManagerRef = "postgresJpaTransactionManager"
)
@Configuration
@EnableConfigurationProperties
public class DatasourcePostgres {

    private static final String PACKAGE_TO_SCAN = "dev.leoduarte.springwebapp.datasource3";

    @Bean
    @ConfigurationProperties("spring.datasource-postgres.jpa")
    public Properties postgresJpaProperties() {
        return new Properties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource-postgres.datasource")
    public DataSourceProperties postgresDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties("spring.datasource-postgres.hikari")
    public HikariConfig postgresHikariConfig() {
        return new HikariConfig();
    }

    @Bean
    public DataSource postgresDataSource(
            @Qualifier("postgresDataSourceProperties")
            DataSourceProperties properties,
            @Qualifier("postgresHikariConfig")
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
    public LocalContainerEntityManagerFactoryBean postgresLocalContainerEntityManagerFactoryBean(
            @Qualifier("postgresDataSource")
            DataSource dataSource,
            @Qualifier("postgresJpaProperties")
            Properties properties) {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan(PACKAGE_TO_SCAN);
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        emf.setJpaProperties(properties);
        return emf;
    }

    @Bean
    public JpaTransactionManager postgresJpaTransactionManager(
            @Qualifier("postgresLocalContainerEntityManagerFactoryBean")
            EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }

}
