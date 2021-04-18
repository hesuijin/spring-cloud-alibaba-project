package com.example.demo.seata.serviceImpl;


import com.example.demo.providerFeignClient.ProviderFeignClientService;
import com.example.demo.seata.service.BusinessService;
import com.example.demo.storageFeignClientService.StorageFeignClientService;
import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalLock;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/17
 */
@Service
@Slf4j
public class BusinessServiceImpl implements BusinessService {

    @Autowired
    StorageFeignClientService storageFeignClientService;

    @Autowired
    ProviderFeignClientService providerFeignClientService;

    /**
     * 通过 storageFeignClientService 调用 storage服务 进行库存的减少
     * 通过 providerFeignClientService 调用 provider服务 进行订单的新增
     *
     * @param userId
     * @param commodityCode
     * @param orderCount
     */
    @Override
    @GlobalTransactional(rollbackFor = RuntimeException.class)
//    @GlobalLock
//    @Transactional(rollbackFor = RuntimeException.class)
    public void purchase(String userId, String commodityCode, Integer orderCount) {
        //为了与日志区分 使用 System打印日志

        System.out.println("进入purchase 购买下单，模拟全局事务提交 请求");
        System.out.println("order XID " + RootContext.getXID());

        //storageService服务  db_storage库  storage_tbl表
        storageFeignClientService.seatadeductStorage(commodityCode, orderCount, "Transactional");
        //providerService服务   db_order库  order_tbl表
        providerFeignClientService.seataCreateOrder(userId, commodityCode, orderCount);
    }

    @Override
    @GlobalTransactional(rollbackFor = RuntimeException.class)
//    @GlobalLock
    public void purchaseFirst(String userId, String commodityCode, Integer orderCount) {
        //为了与日志区分 使用 System打印日志

        System.out.println("我先进行调用 进入purchase 购买下单，模拟全局事务提交 请求");
        System.out.println("我先进行调用  order XID " + RootContext.getXID());

        //storageService服务  db_storage库  storage_tbl表
        storageFeignClientService.seatadeductStorage(commodityCode, orderCount,"GlobalTransactional");

        //休眠30秒，期间去调用其他接口
        try {
            Thread.sleep(1000*30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("我先进行调用  休眠60秒，期间去调用其他接口");

        //providerService服务   db_order库  order_tbl表
        providerFeignClientService.seataCreateOrder(userId, commodityCode, orderCount);

    }
}
