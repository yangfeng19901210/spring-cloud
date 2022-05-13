package com.yf.ordercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-11 11:39
 */
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.yf.ordercenter.dao")
public class SpringOrderCenterApplication {
  public static void main(String[] args) {
    SpringApplication.run(SpringOrderCenterApplication.class,args);
  }

}
