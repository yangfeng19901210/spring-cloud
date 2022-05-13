package com.yf.usercenter.controller;

import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-12 15:53
 */
@RestController
@RequestMapping("/rocketMq")
public class RocketMqController {
  @Autowired
  private RocketMQTemplate rocketMQTemplate;
  /***
   * @describe 测试想rocketmq 发送简单消息
   * @author yangfeng
   * @date 2022-05-12 16:14:24
   * @param msg 发送的消息内容
   * @return
   **/
  @RequestMapping("sendSimpleMsg")
  public String sendSimpleMsg(@RequestParam String msg){
    //消息发送
    rocketMQTemplate.convertAndSend("test-sendStr","你好啊！"+msg);
    return "send ok";
  }


}
