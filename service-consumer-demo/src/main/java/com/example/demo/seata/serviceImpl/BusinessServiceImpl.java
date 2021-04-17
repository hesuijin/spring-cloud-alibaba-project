package com.example.demo.seata.serviceImpl;


import com.example.demo.providerFeignClient.ProviderFeignClientService;
import com.example.demo.seata.service.BusinessService;
import com.example.demo.storageFeignClientService.StorageFeignClientService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
@Service
@Slf4j
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    StorageFeignClientService storageFeignClientService;

    @Autowired
    ProviderFeignClientService providerFeignClientService;

    /**
     * 减库存，下订单
     *
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    @Override
    @GlobalTransactional(rollbackFor = RuntimeException.class)
    public void purchase(String userId, String commodityCode, Integer orderCount) {

        log.info("进入purchase请求");
        //本服务 减少库存
        storageFeignClientService.seatadeductStorage(commodityCode, orderCount);
        //其他服务 下订单
        providerFeignClientService.seataCreateOrder(userId, commodityCode, orderCount);
    }
}
