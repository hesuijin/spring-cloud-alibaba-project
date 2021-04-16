package com.example.demo.providerDemoFeignClient;

import com.example.demo.providerFeignClient.ProviderFeignClientService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/16
 */
@RestController
@RequestMapping(value = "/providerDemoFeignClient")
@Slf4j
public class ProviderDemoFeignClient {

    @Autowired
    ProviderFeignClientService providerFeignClientService;

    @GetMapping(value = "/test")
    public void providerDemoFeignClientTest(){
        log.info("请求/providerDemoFeignClient/test");

        //1:外部请求网关服务 经过校验
        //2:网关服务请求consumer 服务
        //3：consumer服务 请求 providerFeignClient服务
        //4：providerFeignClient服务 请求 provider服务
        String resp;
        for (int i = 0; i < 30; i++) {
            resp =  providerFeignClientService.print();
            log.info("请求结果：{}",resp);
        }
    }
}
