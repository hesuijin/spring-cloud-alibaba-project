package com.example.demo.seata.mapper;

import com.example.demo.seata.entity.Storage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
@Mapper
@Repository
public interface StorageMapper {


    /**
     * @param commodityCode
     * @return
     */
     Storage findByCommodityCode(@Param("commodityCode") String commodityCode);

     int updateById(Storage record);
}
