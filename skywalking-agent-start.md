
##### skywalking的图形界面地址
    经过修改配置文件 并且  启动图形界面后
    http://localhost:10002/

##### skywalking-agent存放路径
    skywalking-agent 需要存放在对应的路径
    必须还是在apache-skywalking-apm-bin 的目录路径下面
    我把解压的软件存放这里 A:\Instrument\apache-skywalking-apm-6.5.0\apache-skywalking-apm-bin


##### 启动 skywalking-agent 命令
    
    1: gateway  新增VM启动参数
    -javaagent:A:\Instrument\apache-skywalking-apm-6.5.0\apache-skywalking-apm-bin\agent\skywalking-agent.jar -Dskywalking.agent.service_name=gateway

    2：service-provider-consumer  新增VM启动参数
    -javaagent:A:\Instrument\apache-skywalking-apm-6.5.0\apache-skywalking-apm-bin\agent\skywalking-agent.jar -Dskywalking.agent.service_name=service-consumer    

    3：service-provider-demo  新增VM启动参数
    -javaagent:A:\Instrument\apache-skywalking-apm-6.5.0\apache-skywalking-apm-bin\agent\skywalking-agent.jar -Dskywalking.agent.service_name=service-provider
    
    4：service-provider-demo-other  新增VM启动参数
    -javaagent:A:\Instrument\apache-skywalking-apm-6.5.0\apache-skywalking-apm-bin\agent\skywalking-agent.jar -Dskywalking.agent.service_name=service-provider-other
       
    5:service-provider-demo-feign  新增VM启动参数
    -javaagent:A:\Instrument\apache-skywalking-apm-6.5.0\apache-skywalking-apm-bin\agent\skywalking-agent.jar -Dskywalking.agent.service_name=service-provider-demo-feign
    