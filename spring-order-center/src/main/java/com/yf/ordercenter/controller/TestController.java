package com.yf.ordercenter.controller;

import com.alibaba.fastjson.JSON;
import com.yf.ordercenter.service.feign.RemoteUserService;
import com.yf.ordercenter.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
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

  @Autowired
  private RemoteUserService remoteUserService;
  @GetMapping("/testHeader")
  public String testHeader(){
    return "header";
  }

  @GetMapping("/testHost")
  public String testHost(){
    return "你好啊，host测试";
  }
  @GetMapping("/testFeignPost")
  public String testFeignPost(){
    remoteUserService.postPojo(OrderVo.builder()
        .id("123")
        .orderName("测试订单")
        .userName("杨峰")
        .userId("135")
        .build()
    );
    return "post ok";
  }

  @GetMapping("/testFeignJsonStr")
  public String testFeignJsonStr(){
    OrderVo orderVo = OrderVo.builder()
        .id("123")
        .orderName("静中等待")
        .userName("合适的实际")
        .userId("135")
        .build();
    String jsonStr = JSON.toJSONString(orderVo);
    remoteUserService.getParam(jsonStr);
    return "post ok";
  }

  @GetMapping("/testFeignManyParam")
  public String testFeignManyParam(){
    String s = remoteUserService.manyParam("54215521", "张永年");
    return s;
  }

  @GetMapping("/testFeignParamToObj")
  public String testFeignParamToObj(){
    remoteUserService.manyParamToObj("54215521", "张永年");
    return "我是一只小鸟";
  }



}
