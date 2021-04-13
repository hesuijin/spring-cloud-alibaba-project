package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//该服务为发现者
@EnableDiscoveryClient
public class ServiceProviderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderDemoApplication.class, args);
    }

}
