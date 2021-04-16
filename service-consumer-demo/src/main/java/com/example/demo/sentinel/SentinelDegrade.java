package com.example.demo.sentinel;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 熔断降级
 * @Author HeSuiJin
 * @Date 2021/4/15
 */
@RestController
@RequestMapping(value = "/sentinelDegrade")
public class SentinelDegrade {
    /**
     * 在构造方法里初始化了熔断 规则。
     * 写在这里只是为了方便测试，实际开发中，规则的初始化可以放在统一的地方，而不是写在每个控制器里
     */
    public SentinelDegrade() {
        initDegradeRules();
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
    @SentinelResource(value = "sentinelDegrade", blockHandler = "handleException", blockHandlerClass = {SentinelException.class})
    public String test() {
        try {
            //睡眠500ms
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "sentinel pass";
    }


    /**
     * 初始化熔断规则
     */
    private static void initDegradeRules() {

//          	【策略1】
//           平均响应时间 (DEGRADE_GRADE_RT)  触发： 1s 内持续进入超过 5 个请求
//           平均响应时间超过 count (10ms) 则熔断 timewindow(10s)
//        rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
//        rule.setCount(10);
//        rule.setTimeWindow(10);

        List<DegradeRule> rules = new ArrayList<DegradeRule>();
        DegradeRule rule = new DegradeRule();
        rule.setResource("sentinelDegrade");
        //降级策略
        rule.setGrade(RuleConstant.DEGRADE_GRADE_RT);
        //平均响应时间 ms
        rule.setCount(10);
        //降级时间 s
        rule.setTimeWindow(10);
        rules.add(rule);
        DegradeRuleManager.loadRules(rules);


//        	【策略2】
//        	异常比例 (DEGRADE_GRADE_EXCEPTION_RATIO) 触发：每秒请求量 >= 5
//        	每秒异常总数占通过量的比值超过阈值count（[0.0, 1.0]，代表 0% - 100%） 之后 则熔断  timewindow(10s)
//        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_RATIO);
//        rule.setCount(0.1);
//        rule.setTimeWindow(10);
//
//        	【策略3】
//        	异常数 (DEGRADE_GRADE_EXCEPTION_COUNT)
//        	当资源近 1 分钟的异常数超过阈值 (count) 之后会进行熔断
//        	注意由于统计时间窗口是分钟级别的，若 timeWindow 小于 60s，则结束熔断状态后仍可能再进入熔断状态。
//       	rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT);
//        rule.setCount(5);
//        rule.setTimeWindow(90);

    }
}
