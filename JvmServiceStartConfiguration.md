####
    GateWay
    -Xms256M
    -Xmx256M
    -Dcsp.sentinel.dashboard.server=localhost:10001
    -Dcsp.sentinel.app.type=1
    -javaagent:A:\Instrument\apache-skywalking-apm-6.5.0\apache-skywalking-apm-bin\agent\skywalking-agent.jar
    -Dskywalking.agent.service_name=gateway

    -Xms256M (设置JVM堆的初始大小)
    -Xmx256M（设置JVM堆的最大大小)
    -Dcsp.sentinel.dashboard.server=localhost:10001  （设置sentinel  限流熔断 可视化界面）
    -Dcsp.sentinel.app.type=1   （设置为网关sentinel类型   除了网关其他服务不用填 ）
    -javaagent:A:\Instrument\apache-skywalking-apm-6.5.0\apache-skywalking-apm-bin\agent\skywalking-agent.jar（设置skywalking 链路追踪界面）
    -Dskywalking.agent.service_name=gateway （设置该服务再skywalking界面的服务名称）
    
    consumer
    -Xms256M
    -Xmx256M
    -Dcsp.sentinel.dashboard.server=localhost:10001
    -javaagent:A:\Instrument\apache-skywalking-apm-6.5.0\apache-skywalking-apm-bin\agent\skywalking-agent.jar
    -Dskywalking.agent.service_name=consumer