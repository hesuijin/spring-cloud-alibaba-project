package com.example.demo.config;

import com.alibaba.cloud.nacos.ribbon.NacosRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/18
 */
@Configuration
public class LoadBalanceNacosFeignConfig {

    /**
     * 轮训策略
     * @return
     */
    @Bean
    @Scope(value="prototype")
    public IRule loadRoundBalanceRule(){
        return new RoundRobinRule();
    }

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
