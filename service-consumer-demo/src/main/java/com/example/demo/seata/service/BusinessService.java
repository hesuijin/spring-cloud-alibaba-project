package com.example.demo.seata.service;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
public interface BusinessService {

    /**减库存，下订单
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    void purchase(String userId, String commodityCode, int orderCount);
}
