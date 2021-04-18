package com.example.demo.seata.serviceImpl;

import com.example.demo.seata.entity.Order;
import com.example.demo.seata.mapper.OrderMapper;
import com.example.demo.seata.service.OrderService;
import io.seata.core.context.RootContext;
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

    /**
     * 创建订单
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    @Override
//    @Transactional(rollbackFor = RuntimeException.class)
    public void createOrder(String userId, String commodityCode, Integer orderCount) {
        System.out.println("XID " + RootContext.getXID());
        BigDecimal orderMoney = new BigDecimal(orderCount).multiply(new BigDecimal(5));
        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setCount(orderCount);
        order.setMoney(orderMoney);
        orderMapper.insert(order);

        //先进 storage服务 执行完逻辑
        //后进 provider服务 使得产生RuntimeException异常
//        storage服务 和 provider服务 都回滚
//        if (true) {
//            throw new RuntimeException("provider service  createOrder exception");
//        }
    }
}
