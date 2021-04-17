package com.example.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
@Configuration
@EnableConfigurationProperties(JdbcProperties.class)
@Slf4j
public class JdbcConfiguration {
    @Bean
    public DataSource dataSource(JdbcProperties jdbcProperties) {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setPassword(jdbcProperties.getPassword());
        dataSource.setUsername(jdbcProperties.getUsername());
        dataSource.setUrl(jdbcProperties.getUrl());
        dataSource.setDriverClassName(jdbcProperties.getDriverClassName());
        return dataSource;
    }
}
