package com.yf.usercenter.service;

import com.yf.usercenter.entity.SysUser;
import com.yf.usercenter.entity.SysUser.SysUserBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.springframework.stereotype.Service;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-11 13:30
 */
@Service
public class UserService {

  private static final Map<String ,SysUser> userMap = new HashMap<String ,SysUser>();
  static {
    SysUser sysUser1 = SysUser.builder().id("16750589-460a-43f5-9796-492959d66d96").name("张三").build();
    SysUser sysUser2 = SysUser.builder().id("798468a8-73af-4497-9ea7-aaea38e7f7ea").name("李四").build();
    SysUser sysUser3 = SysUser.builder().id("9cd610a1-9adb-4f1c-b10e-31a891c5f4f5").name("王五").build();
    SysUser sysUser4 = SysUser.builder().id("90efda41-9925-4dba-ad9c-2477dd0a873a").name("赵六").build();
    SysUser sysUser5 = SysUser.builder().id("88840afb-4444-4be9-a9ad-e9e02af70d2c").name("王麻子").build();
    userMap.put(sysUser1.getId(),sysUser1);
    userMap.put(sysUser2.getId(),sysUser2);
    userMap.put(sysUser3.getId(),sysUser3);
    userMap.put(sysUser4.getId(),sysUser4);
    userMap.put(sysUser5.getId(),sysUser5);
  }

  public SysUser addUser(SysUser sysUser){
    sysUser.setId(UUID.randomUUID().toString());
    userMap.put(sysUser.getId(),sysUser);
    return sysUser;
  }

  public Map getAllUser(){
    return userMap;
  }

  public SysUser getUserById(String id){
    return userMap.get(id);
  }



}
