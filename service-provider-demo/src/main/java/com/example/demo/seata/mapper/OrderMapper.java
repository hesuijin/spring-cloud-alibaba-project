package com.example.demo.seata.mapper;

import com.example.demo.seata.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
@Mapper
@Repository
public interface OrderMapper {

     int insert(Order order);
}
