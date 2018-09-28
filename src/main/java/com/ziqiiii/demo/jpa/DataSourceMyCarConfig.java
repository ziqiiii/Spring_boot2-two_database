package com.ziqiiii.demo.jpa;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * create by ziqi.zhang on 2018/9/28
 */
@Configuration
public class DataSourceMyCarConfig {

    @Bean(name = "myCarDataSourceProperties")
    @ConfigurationProperties("spring.datasource")
    @Primary
    public DataSourceProperties dataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean(name = "myCarDataSource")
    @Qualifier("myCarDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource myCarDataSource(@Qualifier("myCarDataSourceProperties") DataSourceProperties properties){
        return  DataSourceBuilder.create(properties.getClassLoader()).type(HikariDataSource.class)
                .driverClassName(properties.determineDriverClassName())
                .url(properties.determineUrl())
                .username(properties.determineUsername())
                .password(properties.determinePassword())
                .build();
    }
}
