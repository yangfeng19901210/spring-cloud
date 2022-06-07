package com.yf.usercenter.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-11 14:08
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderVo {
  private String id;

  private String orderName;

  private String userId;
  //下单用户昵称
  private String userName;

}
