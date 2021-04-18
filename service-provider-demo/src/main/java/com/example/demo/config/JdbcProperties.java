package com.example.demo.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
@PropertySource("classpath:bootstrap.yml")
@ConfigurationProperties(prefix ="spring.datasource")
@Data
public class JdbcProperties {
    private String url;
    private String driverClassName;
    private String username;
    private String password;
}
