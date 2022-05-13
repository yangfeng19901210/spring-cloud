package com.yf.ordercenter.rocketmq;

import com.alibaba.fastjson.JSON;
import com.yf.ordercenter.dao.RocketmqTransactionLogMapper;
import com.yf.ordercenter.dto.ShareAuditDto;
import com.yf.ordercenter.model.RocketmqTransactionLog;
import com.yf.ordercenter.service.SpringBusShareService;
import java.lang.annotation.Annotation;
import lombok.RequiredArgsConstructor;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-13 15:32
 */
@RocketMQTransactionListener
@RequiredArgsConstructor(onConstructor = @_(@Autowired))
public class RocketmqTransactionListener implements RocketMQLocalTransactionListener {

  private final SpringBusShareService springBusShareService;
  private final RocketmqTransactionLogMapper rocketmqTransactionLogMapper;


  @Override
  public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object args) {
    //从消息有获取参数信息
    /***
     * 从headers中获取到的都是字符串，所以需要强制转换
     **/
    MessageHeaders headers = message.getHeaders();
    String transactionId = (String) headers.get(RocketMQHeaders.TRANSACTION_ID);
    Integer shareId = Integer.valueOf((String) headers.get("share_id"));
    //String dtoString = (String) args;
    System.out.println(args instanceof ShareAuditDto);
    //ShareAuditDto auditDTO = JSON.parseObject(dtoString, ShareAuditDto.class);
    try {
      springBusShareService.auditByIdWithRocketMqLog(shareId, (ShareAuditDto) args,transactionId);
      return RocketMQLocalTransactionState.COMMIT;
    } catch (Exception e) {
      e.printStackTrace();
      return RocketMQLocalTransactionState.ROLLBACK;
    }
  }

  @Override
  public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
    MessageHeaders headers = message.getHeaders();
    String transactionId = (String) headers.get(RocketMQHeaders.TRANSACTION_ID);

    // select * from xxx where transaction_id = xxx
    RocketmqTransactionLog transactionLog = this.rocketmqTransactionLogMapper.selectById(transactionId);
    if (transactionLog != null) {
      return RocketMQLocalTransactionState.COMMIT;
    }
    return RocketMQLocalTransactionState.ROLLBACK;
  }
}
