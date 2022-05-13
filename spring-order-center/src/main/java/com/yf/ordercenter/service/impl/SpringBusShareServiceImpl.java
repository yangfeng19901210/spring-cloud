package com.yf.ordercenter.service.impl;

import com.yf.ordercenter.dao.RocketmqTransactionLogMapper;
import com.yf.ordercenter.dto.ShareAuditDto;
import com.yf.ordercenter.dto.UserAddBonusMsgDTO;
import com.yf.ordercenter.enumeration.ArticleStatus;
import com.yf.ordercenter.model.RocketmqTransactionLog;
import com.yf.ordercenter.model.SpringBusShare;
import com.yf.ordercenter.dao.SpringBusShareMapper;
import com.yf.ordercenter.service.SpringBusShareService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import java.util.UUID;
import javax.annotation.Resource;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 分享表 服务实现类
 * </p>
 *
 * @author yf
 * @since 2022-05-13
 */
@Service
public class SpringBusShareServiceImpl extends ServiceImpl<SpringBusShareMapper, SpringBusShare> implements SpringBusShareService {
  @Autowired
  private RocketMQTemplate rocketMQTemplate;
  @Resource
  private SpringBusShareMapper springBusShareMapper;
  @Resource
  private RocketmqTransactionLogMapper rocketmqTransactionLogMapper;

  @Override
  public void auditById(Integer id, ShareAuditDto shareAuditDto) {
    String transactionId = UUID.randomUUID().toString();
    if(shareAuditDto.getExecuteStatus()== ArticleStatus.REVIEWED.getIndex()){
      SpringBusShare springBusShare = springBusShareMapper.selectById(id);
      rocketMQTemplate.sendMessageInTransaction("tx-share-audit",
          MessageBuilder.withPayload(
              UserAddBonusMsgDTO.builder()
                  .userId(springBusShare.getUserId())
                  .bound(15)
                  .build()
          )
              .setHeader("share_id",id)
              .setHeader(RocketMQHeaders.TRANSACTION_ID,transactionId)
              .build(),shareAuditDto
      );
    }else{
      updateAuditStatus(id,shareAuditDto);
    }


  }
  @Transactional(rollbackFor = Exception.class)
  @Override
  public void updateAuditStatus(Integer id, ShareAuditDto shareAuditDto) {
    SpringBusShare springBusShare = SpringBusShare.builder().id(id)
        .status(shareAuditDto.getExecuteStatus()).build();
    springBusShareMapper.updateById(springBusShare);

  }
  @Transactional(rollbackFor = Exception.class)
  @Override
  public void auditByIdWithRocketMqLog(Integer id, ShareAuditDto shareAuditDto,
      String transactionId) {
    updateAuditStatus(id,shareAuditDto);
    RocketmqTransactionLog rocketmqTransactionLog = RocketmqTransactionLog.builder().transactionId(transactionId)
        .log("审核分享").build();
    rocketmqTransactionLogMapper.insert(rocketmqTransactionLog);


  }
}
