package com.yf.ordercenter.service;

import com.yf.ordercenter.dto.USerOrderDTO;
import com.yf.ordercenter.dto.UserDto;
import com.yf.ordercenter.entity.Order;
import com.yf.ordercenter.service.feign.RemoteUserService;
import com.yf.ordercenter.vo.OrderVo;
import java.util.HashMap;
import java.util.Map;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-11 13:58
 */
@Service
public class OrderService {
  private static final Map<String , Order> orderMap = new HashMap<String ,Order>();
  @Autowired
  private RocketMQTemplate rocketMQTemplate;

  @Autowired
  RemoteUserService remoteUserService;

  static {
    Order order1 = Order.builder()
        .id("010b6026-244f-4bd7-a39f-603a3dddd7c4")
        .orderName("毛巾")
        .userId("16750589-460a-43f5-9796-492959d66d96")
        .build();

    Order order2 = Order.builder()
        .id("6a5629df-d5a9-4d98-b5c9-b3764b98b6ff")
        .orderName("水杯")
        .userId("798468a8-73af-4497-9ea7-aaea38e7f7ea")
        .build();

    Order order3 = Order.builder()
        .id("224fea53-ce9a-45e6-a728-345e9d20cdd0")
        .orderName("苹果")
        .userId("9cd610a1-9adb-4f1c-b10e-31a891c5f4f5")
        .build();

    Order order4 = Order.builder()
        .id("444cef72-750c-46cc-9e2b-0eee802766ed")
        .orderName("凉茶")
        .userId("90efda41-9925-4dba-ad9c-2477dd0a873a")
        .build();

    Order order5 = Order.builder()
        .id("99699e91-9006-4bf7-bc16-090590a3c27d")
        .orderName("绿萝")
        .userId("88840afb-4444-4be9-a9ad-e9e02af70d2c")
        .build();
    orderMap.put(order1.getId(),order1);
    orderMap.put(order2.getId(),order2);
    orderMap.put(order3.getId(),order3);
    orderMap.put(order4.getId(),order4);
    orderMap.put(order5.getId(),order5);
  }

  public OrderVo getOrderById(String id){
    Order order = orderMap.get(id);
    OrderVo orderVo = new OrderVo();
    BeanUtils.copyProperties(order,orderVo);
    //远程调用用户微服务，获取对应的用户信息
    UserDto userDTO = remoteUserService.getUserById(order.getUserId());
    orderVo.setUserName(userDTO.getName());
    return orderVo;
  }

  public Map getAll(){
    return orderMap;
  }

  public void createOrderMsg(){
    rocketMQTemplate.sendMessageInTransaction("order-end-msg",MessageBuilder.withPayload(
        USerOrderDTO.builder()
            .id(1)
            .equipmentNo("no-111")
            .port("7")
            .endReason("订单结束")
            .build()
    ).build(),"name");

  }





}
