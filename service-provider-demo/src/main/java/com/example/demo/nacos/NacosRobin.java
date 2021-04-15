package com.example.demo.nacos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * 进行负载均衡测试
 * @Author HeSuiJin
 * @Date 2021/4/15
 */
@RestController
@Slf4j
public class NacosRobin {

    @RestController
    public class LoadBanlanceApi {

        @GetMapping(value = "/loadBanlance/print")
        public String print() {
            return "我是服务 service-provider-demo";
        }
    }


}