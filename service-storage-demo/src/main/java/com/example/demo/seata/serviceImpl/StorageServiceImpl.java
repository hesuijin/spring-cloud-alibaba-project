package com.example.demo.seata.serviceImpl;

import com.alibaba.fastjson.JSONObject;
import com.example.demo.seata.entity.Storage;
import com.example.demo.seata.mapper.StorageMapper;
import com.example.demo.seata.service.StorageService;
import io.seata.spring.annotation.GlobalLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService{

    @Autowired
    private StorageMapper storageMapper;

    @Override
//    @GlobalLock
    public void deductStorage(String commodityCode, Integer orderCount,String transactionalFlag) {
        //先查库存后减少
        Storage storage = storageMapper.findByCommodityCode(commodityCode);
        log.info(transactionalFlag + " : 睡眠前原来的库存是多少 :{}", JSONObject.toJSONString(storage));
//        if("GlobalTransactional".equals(transactionalFlag)){
//            //休眠5秒，期间去调用其他接口
//            try {
//                Thread.sleep(1000*5);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }

        //只是用来打印
        Storage storageAfter = storageMapper.findByCommodityCode(commodityCode);
        log.info(transactionalFlag + " : 睡眠后原来的库存是多少 :{}", JSONObject.toJSONString(storageAfter));

        storage.setCount(storage.getCount() - orderCount);
        storageMapper.updateById(storage);
        log.info(transactionalFlag + " : 已经修改成功");
    }
}
