package com.yf.usercenter.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-11 13:27
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SysUser {
  private String id;
  private String name;

}
