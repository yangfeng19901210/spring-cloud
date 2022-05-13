package com.yf.ordercenter.dto;

import lombok.Data;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-13 14:57
 */
@Data
public class ShareAuditDto {
  //执行状态
  private int executeStatus;

  private String auditReason;

}
