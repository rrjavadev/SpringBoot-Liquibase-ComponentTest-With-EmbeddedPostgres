package com.experiments.book.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@Configuration
public class ApplicationConfig {

    @Bean
    @Profile("!test")
    public DataSource postgresDataSource(@Value("${spring.datasource.driver-class-name}") String driverClassName,
                                         @Value("${spring.datasource.username}") String username,
                                         @Value("${spring.datasource.password}") String  password,
                                         @Value("${spring.datasource.url}") String jdbcUrl){
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName(driverClassName);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setJdbcUrl(jdbcUrl);

        return new HikariDataSource(hikariConfig);
    }
}
