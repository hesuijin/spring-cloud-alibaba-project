#### 项目介绍
    以SpringCloudAlibaba搭建的一个微服务项目 实现了一个微服务最基本的主要功能  
    配合我在简书的技术文章食用 效果更佳 https://www.jianshu.com/nb/49954281

#### 项目背景
    由于以前公司使用的分布式框架也是 SpringCloud-Alibaba，但工作期间对该项目的一些配置不够熟悉。
    现在主要用于自己实战配置一个分布式项目。

#### 项目技术介绍
 | 技术名称 | 作用 | 优势 |
 | --- | --- | --- |
 | SpringBoot | 取代了SSH（SSM）模式 | 自动装配的快速整合Web服务 |
 | SpringCloudAlibaba | 分布式框架 | 在原生SpringCloud上进行一层封装 更加兼容其他第三方中间件 |
 | Feign | 服务间调度 | SpringCloud自带的功能 实现微服务之间快速调度 |
 | Ribbon | 负载均衡策略 | SpringCloud自带的功能 可以在网关调度或者微服务的调度的时候 实现负载均衡功能  |
 | Nacos | 服务的注册发现中心 | 去中心化的注册发现功能 帮助网关或者微服务快速调度 (可以快速兼容SpringCloudAlibaba) |
 | Nacos | 服务的动态配置中心 | 实时动态配置不需要重启服务(可以快速兼容SpringCloudAlibaba) |
 | Sentinel | 限流熔断 | 可以在网关或者微服务的重要接口使用限流熔断  (可以快速兼容SpringCloudAlibaba)  |
 | SkyWalking | 链路追踪 | 可以针对全部服务进行链路追踪功能  (可以快速兼容SpringCloudAlibaba)  |
 | Seata | 分布式事务 | 针对微服务的痛点快速解决最终一致性问题 (可以快速兼容SpringCloudAlibaba)  |
 | Mysql | 持久化数据库 | 平民数据库（免费 使用人群多 单机可以承担4000QPS ）  |
 | MyBatis | ORM框架 | 半自动框架 如果配合MyBatis-Plus代码编写效率高  |
 | Druid| 数据库连接池 | 阿里开发 内置详细统计SQL的执行性能插件  |      
 
#### 文章阅读流程：      
    微服务 1：  概念       
    微服务 2：  服务注册发现中心（Nacos）
    微服务 3：  配置中心（Nacos）
    微服务 4： Nacos架构源码分析 注册中心 (待完成)
    微服务 5： Nacos架构源码分析 配置中心 (待完成)
    微服务 6： 集成服务网关 SpringCloud GateWay
    微服务 7： 集成服务网关 SpringCloud Robin
    微服务 8：  Robin常见负载均衡策略源码阅读 (待完成)
    微服务 9： 集成Sentinel网关服务 （限流功能）
    微服务 10： Sentinel可视化功能 
    微服务 11： Sentinel的微服务 限流与熔断降级
    微服务 12： 各微服务之间的相互调用 Feign + Nacos（重要 重要 重要）
    微服务 13： 微服务的调用链路追踪 - Skywalking
    微服务 14： 初探微服务分布式事务 - Seata 
    微服务 15： Seata AT模式 核心代码（重要 重要 重要）
    微服务 16： Seata AT模式 并发测试（上）
    微服务 17： Seata AT模式 并发测试（下）
    微服务 18：总览（上）
    微服务 19：总览（下）
    
    至此：一个正常微服务项目的主体功能已经完成
    
    注意：未完成的部分 不影响学习该项目 只是由于时间关系 
          相关源码阅读的部分先留到后面再写。
    
    注意：
        1：Seata的AT事务有点问题无法按照网上教程解决 并发下脏读问题
        2：可以新增一个用户或者鉴权的服务放在网关那里（视业务而定）
        以上两点后续有时间会解决
       
#### 个人博客(上述文章)
    文章链接： https://www.jianshu.com/nb/49954281
    简书：https://www.jianshu.com/u/5adf0da43d75
    

    
#### 学习资料
    文章知识来源主要来源于：赵俊夫先生的博客  以下为原文链接
    https://blog.csdn.net/u011177064/category_9572944.html       
