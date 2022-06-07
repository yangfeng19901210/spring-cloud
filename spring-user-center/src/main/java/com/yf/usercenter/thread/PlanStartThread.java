package com.yf.usercenter.thread;

import com.yf.usercenter.BeanContext;
import com.yf.usercenter.dao.TestMybatisQueryMapper;
import com.yf.usercenter.entity.TestMybatisQuery;
import com.yf.usercenter.service.TestMybatisQueryService;
import java.util.List;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-27 11:34
 */
public class PlanStartThread implements Runnable{
  @Override
  public void run() {
    while (true){
//      for (int i = 0; i <100 ; i++) {
//        System.out.println("正在执行输出=="+i);
//      }
      TestMybatisQueryService service = BeanContext.getApplicationContext()
          .getBean(TestMybatisQueryService.class);
      List<TestMybatisQuery> list1 = service.list();
      System.out.println(list1);
      try {
        Thread.sleep(10*1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

  }
}
