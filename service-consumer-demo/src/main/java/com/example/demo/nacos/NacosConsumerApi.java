package com.example.demo.nacos;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class NacosConsumerApi {
    @Value("${spring.application.name}")
    private String appName;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    private RestTemplate restTemplate = new RestTemplate();

    @GetMapping(value = "/nacos/{string}")
    public String nacos(@PathVariable String string) {

        //使用LoadBalanceClient的方式来获取 nacos-provider的服务信息
        ServiceInstance serviceInstance = loadBalancerClient.choose("nacos-provider");
        log.info( "打印serviceInstance信息：{}",JSONObject.toJSONString(serviceInstance));

        // 对将要请求的url进行组装
        String url = String.format("http://%s:%s/nacos/%s", serviceInstance.getHost(), serviceInstance.getPort(),
                appName);

        http://192.168.137.1:9991/nacos/nacos-consumer
        log.info("你好，我是请求的url request url:{}" , url);

        //注意这里面 restTemplate.getForObject 已经进行了一次请求
        log.info( "打印返回信息：{}",JSONObject.toJSONString(restTemplate.getForObject(url, String.class)));

        return restTemplate.getForObject(url, String.class);
    }


}
