package com.yf.gatewaycenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-16 10:41
 */
@SpringBootApplication
public class GateWayCenterApplication {

//  @Bean
//  public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//    // 关键是下面几行代码
//    return builder.routes()
//        .route("header_route", r -> r.header("some", "xujin")
//            .uri("http://localhost:8032/test/testHeader"))
//        .build();
//  }
  public static void main(String[] args) {
    SpringApplication.run(GateWayCenterApplication.class,args);
  }

}
