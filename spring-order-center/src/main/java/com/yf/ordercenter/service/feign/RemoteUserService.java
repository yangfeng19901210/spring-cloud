package com.yf.ordercenter.service.feign;

import com.yf.ordercenter.dto.UserDto;
import com.yf.ordercenter.vo.OrderVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-center")
public interface RemoteUserService {
  @GetMapping("/user/{id}")
  UserDto getUserById(@PathVariable("id") String id);

  @PostMapping("/feign/getPojo")
  public String postPojo(@RequestBody OrderVo orderVo);
  /***
   * @describe 客户端定义接口的参数和请求的路径
   * @author yangfeng
   * @date 2022-05-26 11:41:34
   * @param str
   * @return
   **/
  @GetMapping("/feign/getParam")
  public String getParam(@RequestParam("jsonStr") String str);

  @GetMapping("/feign/getManyParam")
  public String manyParam(@RequestParam("id") String id,@RequestParam("name") String name);

  @GetMapping("/feign/manyParamToObj")
  public String manyParamToObj(@RequestParam("id") String id,@RequestParam("name") String name);




}
