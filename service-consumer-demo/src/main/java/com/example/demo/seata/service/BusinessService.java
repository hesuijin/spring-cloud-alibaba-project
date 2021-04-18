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
    void purchase(String userId, String commodityCode, Integer orderCount);

    /**
     * 另外的调用
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    void purchaseFirst(String userId, String commodityCode, Integer orderCount);
}
