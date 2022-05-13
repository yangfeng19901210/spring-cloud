package com.yf.usercenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-11 11:23
 */
@SpringBootApplication
@MapperScan("com.yf.usercenter.dao")
public class SpringUserCenterApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringUserCenterApplication.class,args);
  }

}
