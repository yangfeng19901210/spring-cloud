package com.yf.usercenter.service;

import com.yf.usercenter.dto.PlanDto;
import com.yf.usercenter.util.DataUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-30 10:43
 */
@Service
public class PlanService {

  private static List<PlanDto> list = new ArrayList<PlanDto>();

  static{
    PlanDto planDto1 = PlanDto.builder()
        .id(1)
        .startDate(DataUtils.strToDate("2022-01-13"))
        .status(1)
        .build();

    PlanDto planDto2 = PlanDto.builder()
        .id(2)
        .startDate(DataUtils.strToDate("2022-02-23"))
        .status(1)
        .build();

    PlanDto planDto3 = PlanDto.builder()
        .id(3)
        .startDate(DataUtils.strToDate("2022-08-25"))
        .status(1)
        .build();

    PlanDto planDto4 = PlanDto.builder()
        .id(4)
        .startDate(DataUtils.strToDate("2022-07-27"))
        .status(1)
        .build();

    PlanDto planDto5 = PlanDto.builder()
        .id(5)
        .startDate(DataUtils.strToDate("2022-06-29"))
        .status(1)
        .build();

    PlanDto planDto6 = PlanDto.builder()
        .id(6)
        .startDate(DataUtils.strToDate("2022-06-28"))
        .status(1)
        .build();
    list.add(planDto1);
    list.add(planDto2);
    list.add(planDto3);
    list.add(planDto4);
    list.add(planDto5);
    list.add(planDto6);
  }

  public  List<PlanDto> getList(){
    return list;
  }

}
