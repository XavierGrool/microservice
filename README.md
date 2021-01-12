# microservice

该项目是一个课设项目，实现的功能非常简单，仅仅是一个 todo 应用，目的是上手微服务。

该项目一个有 5 个服务，分别是：
1. eureka-server: 服务发现
2. confsvr: 配置中心
3. gateway: api 网关
4. todo-backend: todo 应用的后端
5. todo-frontend: todo 应用的前端

项目运行说明：
每个服务下面都有一个 docker-compose 文件。分别进入每一个模块的目录，输入 docker-compose up，即可启动相应服务。用户可自行决定服务的启动顺序。但要注意的是，用户需自行修改一下 docker-compose 中的相对路径，建议不要有中文字符。