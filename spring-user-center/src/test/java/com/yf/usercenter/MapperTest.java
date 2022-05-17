package com.yf.usercenter;

import com.yf.usercenter.annotation.MyAnnotation;
import com.yf.usercenter.dao.SpringSysUserMapper;
import com.yf.usercenter.model.SpringSysUser;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-13 10:42
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@MyAnnotation(name = "yyps")
public class MapperTest {
  @Resource
  private SpringSysUserMapper springSysUserMapper;
  @Test
  public void addUserTest(){
    SpringSysUser springSysUser = new SpringSysUser();
    springSysUser.setName("王五");
    springSysUserMapper.insert(springSysUser);

  }




}
