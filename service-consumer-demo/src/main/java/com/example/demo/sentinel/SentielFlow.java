package com.example.demo.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author HeSuiJin
 * @Date 2021/4/15
 */
@RestController
@RequestMapping(value = "/sentinelFlow")
public class SentielFlow {

    /**
     * 在构造方法里初始化了 限流 规则。
     * 写在这里只是为了方便测试，实际开发中，规则的初始化可以放在统一的地方，而不是写在每个控制器里
     */
    public SentielFlow() {
        initFlowRules();
    }


    /**
     * 熔断测试接口
     *
     * @return
     * @SentinelResource 中的 value 即为熔断规则中设置的 Resource 名
     * blockHandler与blockHandlerClass 结合起来是定义
     * 熔断后处理逻辑由ExceptionUtil.handleException(前面可加自己的参数,BlockException e)控制
     */
    @GetMapping(value = "/test")
    @SentinelResource(value = "test", blockHandler = "handleException", blockHandlerClass = {SentielException.class})
    public String test() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sentinel pass";
    }


    /**
         * 初始化限流规则
         */
    private static void initFlowRules() {
		/*
		 * 	resource：资源名，即限流规则的作用对象
			count: 限流阈值
			grade: 限流阈值类型（QPS 或并发线程数）
			limitApp: 流控针对的调用来源，若为 default 则不区分调用来源
			strategy: 调用关系限流策略
			controlBehavior: 流量控制效果（直接拒绝、Warm Up、匀速排队）
		 */
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource("test");
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setCount(10);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
