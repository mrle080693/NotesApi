package com.prostosasha.notesapi.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

// Just for work with db not from web
@Configuration
@ComponentScan("com.prostosasha.notesapi")
public class DataSourceConfig {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/notes_database");
        dataSource.setUsername("postgres");
        dataSource.setPassword("root");

        return dataSource;
    }
}
