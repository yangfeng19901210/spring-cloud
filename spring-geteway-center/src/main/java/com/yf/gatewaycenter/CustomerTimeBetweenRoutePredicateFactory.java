package com.yf.gatewaycenter;

import com.yf.gatewaycenter.config.CustomTimeBetweenConfig;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-23 11:34
 */
@Component
@Slf4j
public class CustomerTimeBetweenRoutePredicateFactory extends AbstractRoutePredicateFactory<CustomTimeBetweenConfig> {

  public CustomerTimeBetweenRoutePredicateFactory() {
    super(CustomTimeBetweenConfig.class);
  }

  @Override
  public Predicate<ServerWebExchange> apply(CustomTimeBetweenConfig config) {
    LocalTime start = config.getStartTime();
    LocalTime end = config.getEndTime();
    return exchange -> {
      LocalTime now = LocalTime.now();
      return now.isAfter(start) && now.isBefore(end);
    };
  }

  @Override
  public List<String> shortcutFieldOrder() {
    return Arrays.asList("startTime","endTime");
  }
}
