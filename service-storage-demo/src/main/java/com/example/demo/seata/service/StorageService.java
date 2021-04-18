package com.example.demo.seata.service;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
public interface StorageService {


     void deductStorage(String commodityCode, Integer orderCount,String transactionalFlag);
}
