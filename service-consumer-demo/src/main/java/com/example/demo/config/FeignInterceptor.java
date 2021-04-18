package com.example.demo.config;

import com.alibaba.nacos.client.utils.StringUtils;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import io.seata.core.context.RootContext;
import org.springframework.context.annotation.Configuration;

/**
 * seata 的 AT 模式的 标志 存放到请求头里面
 * HeSuiJin
 */
@Configuration
public class FeignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        String xid = RootContext.getXID();
        if (StringUtils.isNotBlank(xid)) {
			System.out.println("feign xid："+xid);
		}
        requestTemplate.header(RootContext.KEY_XID, xid);
    }
}