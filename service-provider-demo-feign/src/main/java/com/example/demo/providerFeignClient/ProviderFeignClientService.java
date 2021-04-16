package com.example.demo.providerFeignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/16
 */

@FeignClient(name = "nacos-provider" , fallback = ProviderFeignClientServiceFallBack.class)
public interface ProviderFeignClientService {

    /**
     * 入口 调用 provider的/loadBalance/print 方法
     * @return
     */
    @GetMapping(value = "/loadBalance/print",consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
//    @RequestMapping(value = "/loadBalance/print", method = RequestMethod.GET)
    String print();
}
