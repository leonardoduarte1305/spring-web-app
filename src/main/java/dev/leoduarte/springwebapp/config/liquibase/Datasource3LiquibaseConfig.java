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
public class Datasource3LiquibaseConfig implements DatasourceToLiquibasePropertiesBinder {

    @Bean
    @ConfigurationProperties("spring.datasource-postgres.liquibase")
    public LiquibaseProperties liquibasePropertiesForDatasource3() {
        return new LiquibaseProperties();
    }

    @Bean
    public DataSource postgresLiquibaseDatasource(
            @Qualifier("liquibasePropertiesForDatasource3")
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
    public SpringLiquibase datasource3SpringLiquibase(
            @Qualifier("liquibasePropertiesForDatasource3")
            LiquibaseProperties liquibaseProperties,
            @Qualifier("postgresLiquibaseDatasource")
            DataSource dataSource) {
        return springLiquibase(dataSource, liquibaseProperties);
    }
}
