package com.yf.usercenter.dto;

import java.util.Date;
import lombok.Builder;
import lombok.Data;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-30 10:38
 */
@Data
@Builder
public class PlanDto {
  private int id;

  private Date startDate;

  private int status;

}
