package com.yf.ordercenter.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-17 9:50
 */
@RestController
@RequestMapping("/test")
public class TestController {
  @GetMapping("/testHeader")
  public String testHeader(){
    return "header";
  }

  @GetMapping("/testHost")
  public String testHost(){
    return "你好啊，host测试";
  }


}
