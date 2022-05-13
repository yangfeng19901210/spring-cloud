package com.yf.ordercenter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-12 16:51
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class USerOrderDTO{

  private int id;

  private String equipmentNo;

  private String port;

  private String endReason;
}
