package com.yf.ordercenter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-11 13:28
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order {
  private String id;

  private String orderName;

  private String userId;

}
