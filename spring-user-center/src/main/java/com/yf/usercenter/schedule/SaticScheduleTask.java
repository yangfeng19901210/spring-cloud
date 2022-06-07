package com.yf.usercenter.schedule;

import com.yf.usercenter.dto.PlanDto;
import com.yf.usercenter.service.PlanService;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-27 11:21
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling
public class SaticScheduleTask {
  @Autowired
  private PlanService planService;

  //@Scheduled(cron = "0/5 * * * * ?")
  private void configureTasks() {
    System.err.println("执行静态定时任务时间: " + LocalDateTime.now());
    List<PlanDto> list = planService.getList();
    list.stream().forEach(t ->{
      if(t.getStartDate().compareTo(new Date())<=0){
        t.setStatus(2);
      }
    });
    System.out.println(list);
  }


}
