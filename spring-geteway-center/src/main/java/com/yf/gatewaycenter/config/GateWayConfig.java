package com.yf.gatewaycenter.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-17 13:30
 */
@Configuration
public class GateWayConfig {

  @Bean
  public RouteLocator customRouteLocator(RouteLocatorBuilder routeBuild) {
    RouteLocatorBuilder.Builder routes = routeBuild.routes();
    /**
     * 路由配置说明：id唯一，对该路由进行定义
     * method:只有请求方式为GET时才会匹配
     * path，路径必须符合/user/**,例如Gateway/user/1,会路由到 user-center/user/路径中
     *
     */
    routes
        //.route("get_route",r ->r.method("GET").and().path("/user/**").uri("lb://user-center"))
        //.route("path_route",r ->r.path("/user/{segment}","/user/**").uri("lb://user-center"))
        //参数中带有yy参数时才会被路由,并且值等于yf.时才会匹配
        //.route("query_route",r ->r.query("yy","yf.").and().path("/user/**").uri("lb://user-center"));
        /***
         * 设置访问的网段，只有192.168.1.1网段的网络并且子网掩码为24才允许访问
         **/
        .route("query_route",r ->r.remoteAddr("192.168.1.1/24").and().path("/user/**").uri("lb://user-center"));
    return routes.build();
  }

}
