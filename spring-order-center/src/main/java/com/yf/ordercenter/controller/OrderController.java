package com.yf.ordercenter.controller;

import com.yf.ordercenter.service.OrderService;
import com.yf.ordercenter.vo.OrderVo;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-11 15:24
 */
@RestController
@RequestMapping("/order")
public class OrderController {

  @Autowired
  private OrderService orderService;
  @RequestMapping("/getAll")
  public Map getOrderAll(){
    return orderService.getAll();
  }
  @GetMapping("/getById")
  public OrderVo getOrderById(@RequestParam String id){
    return orderService.getOrderById(id);
  }

}
