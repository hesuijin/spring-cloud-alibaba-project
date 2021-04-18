package com.example.demo.storageFeignClientService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
@FeignClient(name = "nacos-storage" )
public interface StorageFeignClientService {

    /**
     * 多个参数 必须加上@RequestParam  否则会报错
     * 注意参数名称必须 feign服务 被调用服务一致
     * 注意参数类型必须  feign服务 被调用服务一致
     *
     * 测试 分布式事务 seata
     * @param commodityCode
     * @param orderCount
     * @return
     */
    @RequestMapping("seataTest/deductStorage")
     void seatadeductStorage( @RequestParam("commodityCode") String commodityCode , @RequestParam("orderCount") Integer orderCount,@RequestParam("transactionalFlag") String transactionalFlag) ;

}
