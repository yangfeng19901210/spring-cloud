package com.yf.usercenter.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-11 11:43
 */
@RestController
@Slf4j
public class HelloController {

  @GetMapping("/hello/{name}")
  public String hello(@PathVariable String name){
    log.info("我被请求了...");
    return name;
  }


}
