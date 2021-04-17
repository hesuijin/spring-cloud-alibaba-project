package com.example.demo.seata.controller;

import com.example.demo.seata.service.OrderService;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
@RestController
@RequestMapping("seataTest")
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping(value = "createOrder")
    public void SeataCreateOrder(@RequestParam("userId") String userId, @RequestParam("commodityCode") String commodityCode, @RequestParam("orderCount") Integer orderCount) {
        System.out.println("我是 service-provider-demo-other 服务 的seata createOrder接口");
        System.out.println("order XID " + RootContext.getXID());
        orderService.createOrder(userId, commodityCode, orderCount);
    }

}
