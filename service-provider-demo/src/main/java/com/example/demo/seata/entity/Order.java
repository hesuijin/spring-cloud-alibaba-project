package com.example.demo.seata.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
@Data
public class Order {

    private Integer id;

    private String userId;

    private String commodityCode;

    private Integer count;

    private BigDecimal money;
}
