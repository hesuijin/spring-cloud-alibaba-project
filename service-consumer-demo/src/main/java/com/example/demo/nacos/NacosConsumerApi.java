package com.example.demo.nacos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/13
 */

@RestController
public class NacosConsumerApi {
    @Value("${spring.application.name}")
    private String appName;

    private RestTemplate restTemplate = new RestTemplate();

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "/nacos/{str}")
    public String nacos(@PathVariable String str) {

        // 使用 LoadBalanceClient 和 RestTemolate 结合的方式来访问
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        String url = String.format("http://%s:%s/nacos/%s", serviceInstance.getHost(), serviceInstance.getPort(),
                appName);
        System.out.println("request url:" + url);
        return restTemplate.getForObject(url, String.class);
    }


}
