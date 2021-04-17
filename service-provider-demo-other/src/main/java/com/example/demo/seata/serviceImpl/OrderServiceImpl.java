package com.example.demo.seata.serviceImpl;

import com.example.demo.seata.entity.Order;
import com.example.demo.seata.mapper.OrderMapper;
import com.example.demo.seata.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public void createOrder(String userId, String commodityCode, Integer orderCount) {
        BigDecimal orderMoney = new BigDecimal(orderCount).multiply(new BigDecimal(5));
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);

        if (true) {
            throw new RuntimeException("account branch exception");
        }

        orderMapper.insert(order);
    }
}
