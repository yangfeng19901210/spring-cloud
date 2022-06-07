package com.yf.gatewaycenter.config;

import java.time.LocalTime;
import lombok.Data;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-23 11:35
 */
@Data
public class CustomTimeBetweenConfig {
  private LocalTime startTime;

  private LocalTime endTime;

}
