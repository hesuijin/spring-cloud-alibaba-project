package com.example.demo.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Description: 进行负载均衡测试
 * @Author HeSuiJin
 * @Date 2021/4/15
 */
@RestController
@Slf4j
public class NacosRobin {

    @GetMapping(value = "/loadBalance/print")
    public String print() {
        log.info(new Date() + "调用：我是服务 service-provider-demo");
        return "我是服务 service-provider-demo";
    }

}
