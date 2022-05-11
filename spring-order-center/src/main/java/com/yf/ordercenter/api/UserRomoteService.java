package com.yf.ordercenter.api;

import com.yf.ordercenter.dto.UserDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-11 14:20
 */
@FeignClient("user-center")
public interface UserRomoteService {

  @GetMapping("/user/{id}")
  UserDto getUserById(@PathVariable("id") String id);

}
