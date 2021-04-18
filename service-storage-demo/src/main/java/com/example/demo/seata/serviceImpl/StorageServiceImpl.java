package com.example.demo.seata.serviceImpl;

import com.example.demo.seata.entity.Storage;
import com.example.demo.seata.mapper.StorageMapper;
import com.example.demo.seata.service.StorageService;
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
    public void deductStorage(String commodityCode, Integer orderCount) {
        //There is a latent isolation problem here.
        //I hope that users can solve it and deepen their understanding of seata isolation.
        //At the bottom I will put a reference solution.
        Storage storage = storageMapper.findByCommodityCode(commodityCode);
        storage.setCount(storage.getCount() - orderCount);
        storageMapper.updateById(storage);
    }
}
