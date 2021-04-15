package com.example.demo.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/15
 */
@RefreshScope
@RestController
@Slf4j
public class NacosConfig {

    @Value("${app.version}")
    private String version;

    @GetMapping(value = "/config/version")
    public String version() {
        return "Hello Nacos Config " + version;
    }
}
