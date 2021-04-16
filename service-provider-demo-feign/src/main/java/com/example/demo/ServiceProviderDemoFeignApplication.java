package com.example.demo;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class ServiceProviderDemoFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProviderDemoFeignApplication.class, args);
    }

//    /**
//     * 轮训策略
//     * @return
//     */
//    @Bean
//    @Scope(value="prototype")
//    public IRule loadRoundBalanceRule(){
//        return new RoundRobinRule();
//    }

//    /**
//     * 权重策略
//     * @return
//     */
//    @Bean
//    @Scope(value="prototype")
//    public IRule loadNacosBalanceRule(){
//        return new NacosRule();
//    }
}
