package com.yf.usercenter.controller;
import com.yf.usercenter.dto.UserDTO;
import com.yf.usercenter.vo.OrderVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-26 10:50
 */
@RestController
@RequestMapping("/feign")
public class FeignTestController {
  @PostMapping("/getPojo")
  public OrderVo getPostParam(@RequestBody OrderVo orderVo){
    System.out.println(orderVo);
    return orderVo;

  }
  /***
   * @describe  服务端接受对应的参数即可，不要标注@RequestParam
   * @author yangfeng
   * @date 2022-05-26 11:42:19
   * @param jsonStr
   * @return
   **/
  @GetMapping("/getParam")
  public String getParam(String jsonStr){
    System.out.println(jsonStr);
    return jsonStr;
  }

  @GetMapping("/getManyParam")
  public String getManyParam(String id,String name){
    System.out.println(id+name);
    return id+name;
  }

  @GetMapping("/manyParamToObj")
  public UserDTO manyParamToObj(String id,String name){
    UserDTO userDTO = new UserDTO();
    userDTO.setId(id);
    userDTO.setName(name);
    System.out.println(userDTO);
    return userDTO;
  }


}
