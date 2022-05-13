package com.yf.ordercenter.service;

import com.yf.ordercenter.dto.ShareAuditDto;
import com.yf.ordercenter.model.SpringBusShare;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 分享表 服务类
 * </p>
 *
 * @author yf
 * @since 2022-05-13
 */
public interface SpringBusShareService extends IService<SpringBusShare> {

  public void auditById(Integer id, ShareAuditDto shareAuditDto);

  public void updateAuditStatus(Integer id, ShareAuditDto shareAuditDto);

  public void auditByIdWithRocketMqLog(Integer id, ShareAuditDto shareAuditDto,String transactionId);

}
