package com.example.demo.providerFeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
     * 多个参数 必须加上@RequestParam  否则会报错
     * 注意参数名称必须 feign服务 被调用服务一致
     * 注意参数类型必须  feign服务 被调用服务一致
     *
     * 测试 分布式事务 seata
     * @param userId
     * @param commodityCode
     * @param orderCount
     * @return
     */
    @GetMapping(value = "/seataTest/createOrder")
    String createOrder(@RequestParam("userId")String userId, @RequestParam("commodityCode")String commodityCode,@RequestParam("orderCount") Integer orderCount);
}
