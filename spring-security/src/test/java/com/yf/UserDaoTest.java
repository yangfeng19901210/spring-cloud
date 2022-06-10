package com.yf;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yf.dao.SysUserDao;
import com.yf.entity.SysPermission;
import com.yf.entity.SysUser;
import java.util.List;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-06-09 15:10
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {

  @Resource
  private SysUserDao sysUserDao;
  @Test
  public void testGetUserByUserName(){
    SysUser sysUser = sysUserDao.getUserByUserName("admin");
    System.out.println(sysUser);
  }

  @Test
  public void testPermissionByUserName(){
    List<SysPermission> pers = sysUserDao.getPermissionsByUserName("userAdd");
    System.out.println(pers);

  }



}
