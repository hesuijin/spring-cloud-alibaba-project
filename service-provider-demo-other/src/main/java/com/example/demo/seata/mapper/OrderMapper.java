package com.example.demo.seata.mapper;

import com.example.demo.seata.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.Mapping;

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
