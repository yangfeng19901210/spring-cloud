package com.yf.ordercenter;

import com.yf.ordercenter.dao.SpringBusShareMapper;
import com.yf.ordercenter.model.SpringBusShare;
import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-13 11:31
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class MapperTest {
  @Autowired
  private SpringBusShareMapper springBusShareMapper;
  @Test
  public void addShareTest(){
    SpringBusShare busShare = SpringBusShare.builder()
        .title("java实战之RocketMq")
        .content("rocketmq事务消息发送")
        .userId(1)
        .creteTime(new Date())
        .build();
    springBusShareMapper.insert(busShare);
  }


}
