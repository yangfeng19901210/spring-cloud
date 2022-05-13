package com.yf.usercenter.rocket;

import com.yf.usercenter.dto.UserAddBonusMsgDTO;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-13 16:11
 */
@Component
@RocketMQMessageListener(topic = "tx-share-audit",consumerGroup = "tx-add-bound-group")
@Slf4j
public class TxAddboundConsumerListener implements RocketMQListener<UserAddBonusMsgDTO> {

  @Override
  public void onMessage(UserAddBonusMsgDTO message) {
    log.info("topic-tx received message: {}", message);
  }
}
