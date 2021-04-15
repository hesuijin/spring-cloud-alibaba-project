
##### 启动可视化 sentinel-dashboard  于Terminal执行
java -Dserver.port=10001 -Dcsp.sentinel.dashboard.server=localhost:10001 -Dproject.name=sentinel-dashboard -jar sentinel-dashboard-1.8.1.jar
 
##### 启动Gateway 配置Vm参数

-Dcsp.sentinel.dashboard.server=127.0.0.1:10001 -Dcsp.sentinel.app.type=1

配置运行中的控制台IP:端口
-Dcsp.sentinel.dashboard.server   
设置当前应用为 网关类型  （因为我们是在gateway中使用sentinel）
-Dcsp.sentinel.app.type 
