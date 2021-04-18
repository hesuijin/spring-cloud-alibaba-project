package com.example.demo.seata.controller;

import com.example.demo.seata.entity.Storage;
import com.example.demo.seata.service.StorageService;
//import io.seata.core.context.RootContext;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
@RestController
@RequestMapping("seataTest")
@Slf4j
public class StorageController {

    @Autowired
    StorageService storageService;

    /**
     * 减少库存
     *
     * @return
     */
    @RequestMapping("/deductStorage")
    public void seataDeductStorage( @RequestParam("commodityCode") String commodityCode , @RequestParam("orderCount") Integer orderCount,@RequestParam("transactionalFlag") String transactionalFlag) {
        System.out.println("我是 service-storage-demo服务 的seata deductStorage接口");
        System.out.println("XID " + RootContext.getXID());
        storageService.deductStorage(commodityCode, orderCount,transactionalFlag);
    }

}
