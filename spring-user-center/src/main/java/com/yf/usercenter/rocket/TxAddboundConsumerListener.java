package com.yf.usercenter.rocket;

import com.yf.usercenter.dao.SpringBusBoundAddLogMapper;
import com.yf.usercenter.dao.SpringSysUserMapper;
import com.yf.usercenter.dto.UserAddBonusMsgDTO;
import com.yf.usercenter.model.SpringBusBoundAddLog;
import com.yf.usercenter.model.SpringSysUser;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
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
  @Autowired
  private SpringSysUserMapper springSysUserMapper;

  @Autowired
  private SpringBusBoundAddLogMapper springBusBoundAddLogMapper;

  @Override
  public void onMessage(UserAddBonusMsgDTO message) {
    log.info("topic-tx received message: {}", message);
    SpringSysUser springSysUser = springSysUserMapper.selectById(message.getUserId());
    if(null==springSysUser.getBound()){
      springSysUser.setBound(message.getBound());
    }else{
      springSysUser.setBound(springSysUser.getBound()+message.getBound());
    }
    springSysUserMapper.updateById(springSysUser);
    //用户新增积分记录
    addBoundLog(message);
  }

  private void addBoundLog(UserAddBonusMsgDTO msgDTO){
    SpringBusBoundAddLog springBusBoundAddLog = SpringBusBoundAddLog.builder()
        .userId(msgDTO.getUserId())
        .bound(msgDTO.getBound())
        .createTime(new Date())
        .build();
    springBusBoundAddLogMapper.insert(springBusBoundAddLog);


  }
}
