package com.example.demo.seata.serviceImpl;

import com.example.demo.seata.service.BusinessService;
import com.example.demo.seata.service.StorageService;
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
    StorageService storageService;

    /**
     * 减库存，下订单
     *
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    @Override
    public void purchase(String userId, String commodityCode, int orderCount) {
        storageService.deduct(commodityCode, orderCount);
    }
}
