package com.example.demo;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.sql.SQLException;
@Configuration

public class DemoDataSource {
    @Bean(name = "dataSourceConfig")
    @ConfigurationProperties(prefix = "data.config")
    public DataSourceConfig demoDataBaseConfig() {
        return new DataSourceConfig();
    }

    @Bean(name = "veloHikariDataSource")
    @Primary
    public DataSource hikariDataSource(@Qualifier("dataSourceConfig") DataSourceConfig dataSourceConfig)
            throws SQLException {
        HikariDataSource hikariDataSource = new HikariDataSource();
        hikariDataSource.setDriverClassName(dataSourceConfig.getDriver());
        hikariDataSource.setUsername(dataSourceConfig.getUserName());
        hikariDataSource.setPassword(dataSourceConfig.getPassword());
        hikariDataSource.setJdbcUrl(dataSourceConfig.getUrl());
        hikariDataSource.setMaximumPoolSize(dataSourceConfig.getMaxPoolSize());
        hikariDataSource.setMinimumIdle(1);
        hikariDataSource.setConnectionInitSql("select 1");
        return hikariDataSource;
    }
}
