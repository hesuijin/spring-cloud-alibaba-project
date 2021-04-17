package com.example.demo.seata.service;

import com.example.demo.seata.entity.Storage;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
public interface StorageService {

    public void deduct(String commodityCode, int count) ;

}
