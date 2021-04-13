package com.example.demo.nacos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * 一个简单的controller接口
 * @Author HeSuiJin
 * @Date 2021/4/13
 */
@RestController
public class NacosProviderApi {

    @GetMapping(value = "/nacos/{string}")
    public String nacos(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }
}






