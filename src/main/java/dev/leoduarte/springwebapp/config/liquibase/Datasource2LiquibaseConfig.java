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

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties
public class Datasource2LiquibaseConfig implements DatasourceToLiquibasePropertiesBinder {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasourcemysql2.liquibase")
    public LiquibaseProperties liquibasePropertiesForDataSource2() {
        return new LiquibaseProperties();
    }

    @Bean
    public DataSource mysql2LiquibaseDataSource(
            @Qualifier("liquibasePropertiesForDataSource2")
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
    public SpringLiquibase datasource2SpringLiquibase(
            @Qualifier("liquibasePropertiesForDataSource2") LiquibaseProperties properties,
            @Qualifier("mysql2LiquibaseDataSource") DataSource datasource) {
        return springLiquibase(datasource, properties);
    }

}
