package com.example.demo.seata.service;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
public interface OrderService {

     void createOrder(String userId, String commodityCode, Integer count);
}
