package com.example.demo.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 一个简单的controller接口
 * @Author HeSuiJin
 * @Date 2021/4/13
 */
@RestController
@Slf4j
public class NacosProviderApi {

    @GetMapping(value = "/nacos/{string}")
    public String nacos(@PathVariable String string) {
        log.info("请求到服务发现端 /nacos/{string} 的接口");
        return "Hello Nacos Discovery " + string;
    }


}






