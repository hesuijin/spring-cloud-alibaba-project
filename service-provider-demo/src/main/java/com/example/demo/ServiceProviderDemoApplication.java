package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class ServiceProviderDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderDemoApplication.class, args);
    }

}
