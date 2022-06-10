package com.yf.usercenter;

import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.yf.usercenter.annotation.MyAnnotation;
import com.yf.usercenter.dao.SpringSysUserMapper;
import com.yf.usercenter.dao.TestMybatisQueryMapper;
import com.yf.usercenter.entity.TestMybatisQuery;
import com.yf.usercenter.model.SpringSysUser;
import com.yf.usercenter.service.TestMybatisQueryService;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
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
  @Autowired
  private TestMybatisQueryMapper testMybatisQueryMapper;

  @Autowired
  private TestMybatisQueryService testMybatisQueryService;

  @Test
  public void addUserTest(){
    SpringSysUser springSysUser = new SpringSysUser();
    springSysUser.setName("王五");
    springSysUserMapper.insert(springSysUser);

  }

  //测试新增
  @Test
  public void testAdd(){
    TestMybatisQuery testMybatisQuery = TestMybatisQuery.builder()
        .name("王层县")
        .age(53)
        .sex("男")
        .salary(25100.00)
        .build();
    testMybatisQueryMapper.insert(testMybatisQuery);

  }

  @Test
  public void testQuery(){
    QueryWrapper<TestMybatisQuery> queryWrapper = new QueryWrapper<TestMybatisQuery>();
    queryWrapper.lambda().like(TestMybatisQuery::getName,"包").eq(TestMybatisQuery::getSex,"男");
    List<TestMybatisQuery> list = testMybatisQueryMapper.selectList(queryWrapper);
    System.out.println(list);

  }

  @Test
  public void testRemove(){
    testMybatisQueryService.removeById(3);
  }

  @Test
  public void testGetAll(){
    List<TestMybatisQuery> list = testMybatisQueryService.list();
    List<TestMybatisQuery> list1 = list.stream().filter(t -> t.getSalary() >= 25000.00)
        .collect(Collectors.toList());
    System.out.println(list1);
    double sum = list.stream().mapToDouble(m -> m.getSalary()).sum();
    System.out.println("所有员工的总工资为："+sum);
    double sum1 = list.stream().mapToDouble(TestMybatisQuery::getSalary).sum();
  }

  //测试批量插入数据
  @Test
  public void insertBatch(){
    List<TestMybatisQuery> list = new ArrayList<TestMybatisQuery>();
    list.add(new TestMybatisQuery("张小建",25,"男",8600.00));
    list.add(new TestMybatisQuery("华小毛",29,"女",5000.00));
    list.add(new TestMybatisQuery("刘晓宇",31,"男",6400.00));
    list.add(new TestMybatisQuery("陈云",33,"男",6500.00));
    list.add(new TestMybatisQuery("张永健",35,"男",7600.00));
    testMybatisQueryService.saveBatch(list);
  }

  //获取年龄大于30岁的员工，并输出
  @Test
  public void testFilterByAge(){
    List<TestMybatisQuery> list = testMybatisQueryService.list();
    list.stream().filter(t ->t.getAge()>30).forEach(s-> System.out.println(s));
  }

  //获取所有员工的平均工资
  @Test
  public void testGetAverageSalary(){
    List<TestMybatisQuery> list = testMybatisQueryService.list();
    double v = list.stream().mapToDouble(TestMybatisQuery::getSalary).average().orElse(0.0);
    System.out.println("所有员工的平均工资为："+v);
  }

  @Test
  public void testQueryByIdAndName(){
    LambdaQueryWrapper<TestMybatisQuery> query = new LambdaQueryWrapper<TestMybatisQuery>();
    List<TestMybatisQuery> list = testMybatisQueryMapper
        .selectList(query.eq(TestMybatisQuery::getId, 2).eq(TestMybatisQuery::getName, "张永年"));
    System.out.println(list);

  }







}
