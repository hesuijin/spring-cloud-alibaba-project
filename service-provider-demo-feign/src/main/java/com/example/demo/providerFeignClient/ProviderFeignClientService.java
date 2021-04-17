package com.example.demo.providerFeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/16
 */

@FeignClient(name = "nacos-provider" )
public interface ProviderFeignClientService {

    /**
     * 入口 调用 provider的/loadBalance/print 方法
     * @return
     */
    @GetMapping(value = "/loadBalance/print")
    String print();


    /**
     * 测试 分布式事务 seata
     * @param userId
     * @param commodityCode
     * @param orderCount
     * @return
     */
    @GetMapping(value = "/seataTest/createOrder")
    String createOrder(String userId, String commodityCode, int orderCount);
}
