package com.yf.usercenter.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-13 15:10
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserAddBonusMsgDTO implements Serializable {
  private int userId;
  private int bound;

}
