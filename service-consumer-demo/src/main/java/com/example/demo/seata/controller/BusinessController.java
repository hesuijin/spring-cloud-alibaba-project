package com.example.demo.seata.controller;

import com.example.demo.seata.service.BusinessService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
public class BusinessController {

    @Autowired
    BusinessService businessService;

    /**
     * 购买下单，模拟全局事务提交
     *
     * @return
     */
    @RequestMapping("/purchase/commit")
    public Boolean purchaseCommit(HttpServletRequest request) {
        businessService.purchase("1001", "2001", 1);
        return true;
    }

}
