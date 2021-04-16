package com.example.gateway.config;

import com.alibaba.csp.sentinel.adapter.gateway.common.SentinelGatewayConstants;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiDefinition;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPathPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.ApiPredicateItem;
import com.alibaba.csp.sentinel.adapter.gateway.common.api.GatewayApiDefinitionManager;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayFlowRule;
import com.alibaba.csp.sentinel.adapter.gateway.common.rule.GatewayRuleManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.SentinelGatewayFilter;
import com.alibaba.csp.sentinel.adapter.gateway.sc.callback.GatewayCallbackManager;
import com.alibaba.csp.sentinel.adapter.gateway.sc.exception.SentinelGatewayBlockExceptionHandler;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.reactive.result.view.ViewResolver;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Description: Sentinel限流配置
 * @Author HeSuiJin
 * @Date 2021/4/15
 */
@Configuration
public class GatewaySentinelConfiguration {

    private final List<ViewResolver> viewResolvers;
    private final ServerCodecConfigurer serverCodecConfigurer;

    /**
     * 构造方法
     * @param viewResolversProvider
     * @param serverCodecConfigurer
     */
    public GatewaySentinelConfiguration(ObjectProvider<List<ViewResolver>> viewResolversProvider,
                                ServerCodecConfigurer serverCodecConfigurer) {
        this.viewResolvers = viewResolversProvider.getIfAvailable(Collections::emptyList);
        this.serverCodecConfigurer = serverCodecConfigurer;
    }

    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public SentinelGatewayBlockExceptionHandler sentinelGatewayBlockExceptionHandler() {
        // Register the block exception handler for Spring Cloud Gateway.
        return new SentinelGatewayBlockExceptionHandler(viewResolvers, serverCodecConfigurer);
    }

    @Bean
    @Order(-1)
    public GlobalFilter sentinelGatewayFilter() {
        return new SentinelGatewayFilter();
    }

    @PostConstruct
    public void doInit() {
        initCustomizedApis();
        initGatewayRules();
        //设置 自定义返回异常
        GatewayCallbackManager.setBlockHandler(new MyBlockRequestHandler());
    }

    /**
     * 设置进行限流的Api集合
     */
    private void initCustomizedApis() {
        /*
            ApiDefinition：用户自定义的 API 定义分组，可以看做是一些 URL 匹配的组合。
            比如我们可以定义一个 API 叫 myGateway，
            请求 path 模式为
            /nacos-provider/loadBalance/print  默认为准确的         URL_MATCH_STRATEGY_EXACT
             /nacos-provider/loadBalance/**    如需/**需要设置成    URL_MATCH_STRATEGY_PREFIX
             的都归到 myGateway 这个 API 分组下面。
         */

        //限流的时候可以针对这个自定义的 API 分组维度进行限流。
        Set<ApiDefinition> definitions = new HashSet<>();
        //设置限流路径
        ApiDefinition api = new ApiDefinition("myGateway")
                .setPredicateItems(new HashSet<ApiPredicateItem>() {{
                    add(new ApiPathPredicateItem()
//                            .setPattern("/nacos-provider/loadBanlance/print")
                            .setPattern("/nacos-provider/loadBalance/**")
                            .setMatchStrategy(SentinelGatewayConstants.URL_MATCH_STRATEGY_PREFIX)
                    );
                }});

        definitions.add(api);
        GatewayApiDefinitionManager.loadApiDefinitions(definitions);
    }

    /**
     * 设置限流的Api集合的具体限流
     */
    private void initGatewayRules() {
        /*
        GatewayFlowRule：网关限流规则，
        针对 API Gateway 的场景定制的限流规则，可以针对不同 route 或自定义的 API 分组进行限流，
        支持针对请求中的参数、Header、来源 IP 等进行定制化的限流。
        */
        Set<GatewayFlowRule> rules = new HashSet<>();

        /*设置限流规则
        count: QPS即每秒钟允许的调用次数
        intervalSec: 每隔多少时间统计一次汇总数据，统计时间窗口，单位是秒，默认是 1 秒。
        */
        //针对上面的  自定义ApiDefinition分组进行限流
        rules.add(new GatewayFlowRule("myGateway")
                .setResourceMode(SentinelGatewayConstants.RESOURCE_MODE_CUSTOM_API_NAME)
                .setCount(5)
                .setIntervalSec(1)

        );
        GatewayRuleManager.loadRules(rules);
    }
}
