package com.yf.ordercenter.controller;


import com.yf.ordercenter.dto.ShareAuditDto;
import com.yf.ordercenter.service.SpringBusShareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 分享表 前端控制器
 * </p>
 *
 * @author yf
 * @since 2022-05-13
 */
@RestController
@RequestMapping("/springBusShare")
public class SpringBusShareController {

  @Autowired
  private SpringBusShareService springBusShareService;
  @GetMapping("/shareAuditById")
  public String shareAuditById(Integer id, ShareAuditDto shareAuditDto){
    springBusShareService.auditById(id,shareAuditDto);
    return "excute finish";
  }


}
