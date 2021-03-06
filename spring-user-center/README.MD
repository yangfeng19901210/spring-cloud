## nacos 配置管理
步骤一：启动nacos服务
步骤二：在对应的微服务中添加jar依赖
<!--nacos配置管理，必须引入-->
     <!--服务注册，必须引入-->
        <dependency>
          <groupId>com.alibaba.cloud</groupId>
          <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        <!--nacos配置管理，必须引入-->
        <dependency>
          <groupId>com.alibaba.cloud</groupId>
          <artifactId>spring-cloud-starter-alibaba-nacos-config</artifactId>
        </dependency>
        <!--不引入时启动报错-->
        <dependency>
          <groupId>org.springframework.cloud</groupId>
          <artifactId>spring-cloud-starter-bootstrap</artifactId>
        </dependency>
步骤三：在bootstrap.yml中添加配置
server:
  port: 8033

spring:
  application:
    #服务名称定义
    name: user-center
  profiles:
    # 环境切换
    active: test
  cloud:
    sentinel:
      transport:
        # 配置连接控制台
        dashboard: 127.0.0.1:8080
    nacos:
      discovery:
        #nacos地址
        server-addr: localhost:8848
      # nacos 配置文件格式
      config:
        file-extension: yaml

![Image text](https://github.com/yangfeng19901210/spring-cloud/blob/master/spring-user-center/src/main/resources/images/nacosconfig.png)
步骤四：启动项目进行测试

export JAVA_HOME=/usr/java/jdk1.8.0_333
export CLASSPATH=.:%JAVA_HOME/lib/dt.jar:%JAVA_HOME/lib/tools.jar
export PATH=$PATH:$JAVA_HOME/bin

namesrvAddr=192.168.1.19:9876
brokerIP1=192.168.1.19
#启动nameserv
nohup sh bin/mqnamesrv > ~/logs/rocketmqlogs/namesrv.log &
#启动broker
nohup sh bin/mqbroker -n 192.168.1.19:9876 -c conf/broker.conf autoCreateTopicEnable=true > ~/logs/rocketmqlogs/broker.log &

##rocketmq 服务关闭
先关闭broker服务 ：sh bin/mqshutdown broker
然后关闭namesrv服务：sh bin/mqshutdown namesrv
