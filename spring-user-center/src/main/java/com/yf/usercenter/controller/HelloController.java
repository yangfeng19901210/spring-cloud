package com.yf.usercenter.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-11 11:43
 */
@RestController
@Slf4j
@Controller
public class HelloController {

  @GetMapping("/hello/{name}")
  public String hello(@PathVariable String name){
    log.info("我被请求了...");
    return name;
  }
  @GetMapping("/before")
  public String testBefore(){
    return "before";
  }

  @GetMapping("/between")
  public String testBetween(){
    return "between";
  }

  @GetMapping("/cookie")
  public String testCookie(HttpServletRequest request){
    Cookie[] cookies = request.getCookies();
    for (int i = 0; i < cookies.length; i++) {
      System.out.println(cookies[i].getName()+cookies[i].getValue());
    }
    return "cookie";
  }

  @GetMapping("/gwHeader")
  public String testHeader(HttpServletRequest request){
    String header = request.getHeader("X-Request-Id");
    System.out.println(header);
    return "header";
  }


}
