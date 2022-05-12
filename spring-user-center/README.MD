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
![Image text](https://github.com/yangfeng19901210/spring-cloud/blob/master/spring-user-center/src/main/resources/images/nacosconfig.png)
步骤四：启动项目进行测试
