package com.yf.ordercenter.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.springframework.stereotype.Service;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-12 16:18
 */
@Service
@Slf4j
@RocketMQMessageListener(consumerGroup = "consumer-group",topic = "test-sendStr")
public class SimpleMsgListener implements RocketMQListener<String> {
  @Override
  public void onMessage(String msg) {
    log.info("正在消费消息={}",msg);
  }
}
