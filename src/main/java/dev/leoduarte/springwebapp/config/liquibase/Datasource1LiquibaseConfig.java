package dev.leoduarte.springwebapp.config.liquibase;

import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties
public class Datasource1LiquibaseConfig implements DatasourceToLiquibasePropertiesBinder {

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasourcemysql1.liquibase")
    public LiquibaseProperties liquibasePropertiesForDataSource1() {
        return new LiquibaseProperties();
    }

    @Bean
    public DataSource mysql1LiquibaseDataSource(
            @Qualifier("liquibasePropertiesForDataSource1")
            LiquibaseProperties properties) {
        return DataSourceBuilder
                .create()
                .url(properties.getUrl())
                .driverClassName(properties.getDriverClassName())
                .username(properties.getUser())
                .password(properties.getPassword())
                .build();
    }

    @Bean
    @Primary
    public SpringLiquibase datasource1SpringLiquibase(
            @Qualifier("liquibasePropertiesForDataSource1")
            LiquibaseProperties properties,
            @Qualifier("mysql1LiquibaseDataSource")
            DataSource datasource) {
        return springLiquibase(datasource, properties);
    }

}
