package com.yf.usercenter.controller;

import com.yf.usercenter.entity.SysUser;
import com.yf.usercenter.service.UserService;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-11 13:35
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
  @Autowired
  private UserService userService;

  @Value("${user.name}")
  private String name;

  @Value("${user.age}")
  private Integer age;

  @PostMapping("/add")
  public SysUser addUser(@RequestBody  SysUser sysUser){
    return userService.addUser(sysUser);
  }
  /**
   * @describe 查询所有的用户信息
   * @author yangfeng
   * @date 2022-05-11 16:25:30
   * @return
   **/
  @GetMapping("/getAllUser")
  public Map getAllUser(){
    return userService.getAllUser();
  }
  /**
   * @describe 根据id查询用户信息
   * @author yangfeng
   * @date 2022-05-11 16:24:58
   * @param id
   * @return
   **/
  @GetMapping("/{id}")
  public SysUser getUserById(@PathVariable String id){
    log.info("我被请求了，请求id={}",id);
    return userService.getUserById(id);
  }
  @GetMapping("/getConfig")
  public String getCongigure(){
    return age+name;
  }

}
