package com.yf.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yf.dao.SysUserDao;
import com.yf.entity.SysPermission;
import com.yf.entity.SysUser;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-06-09 15:26
 */
@Service
@Slf4j
public class MyUserDetailService implements UserDetailsService {
  @Resource
  private SysUserDao sysUserDao;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //根据用户名从数据库查询用户信息
    SysUser sysUser = sysUserDao.getUserByUserName(username);
    //给用户设置权限
    List<SysPermission> permissions = sysUserDao.getPermissionsByUserName(username);
    log.info("用户 {} 对应的权限为 {}",username,permissions);
    if(null!= permissions && permissions.size()>0){
      List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
      permissions.stream().forEach(p ->{
        authorities.add(new SimpleGrantedAuthority(p.getPermtag()));
      });
      sysUser.setAuthorities(authorities);
    }
    return sysUser;
  }

  public static void main(String[] args) {
   BCryptPasswordEncoder bCryptPasswordEncoder =  new BCryptPasswordEncoder();
    System.out.println(bCryptPasswordEncoder.encode("123456"));
  }
}
