package io.varunu28.dbosdemo;

import dev.dbos.transact.spring.DBOSConfigCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DbosCustomizerConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();

        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/mydatabase");
        dataSource.setUsername("myuser");
        dataSource.setPassword("secret");
        return dataSource;
    }

    @Bean
    @Order(1)
    public DBOSConfigCustomizer dbosConfigCustomizer() {
        return config -> config
                .withDataSource(dataSource())
                .withAppName("dbos-demo")
                .enableAdminServer();
    }
}
