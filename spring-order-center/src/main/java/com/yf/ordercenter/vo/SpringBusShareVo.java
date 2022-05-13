package com.yf.ordercenter.vo;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-13 14:13
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpringBusShareVo {
  /**
   * 主键
   */
  private Integer id;

  /**
   * 文章标题
   */
  private String title;

  /**
   * 文章内容
   */
  private String content;

  /**
   * 用户id
   */
  private Integer userId;

  /**
   * 分享时间
   */
  private Date creteTime;

}
