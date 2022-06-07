package com.yf.usercenter.service.impl;

import com.yf.usercenter.entity.TestMybatisQuery;
import com.yf.usercenter.dao.TestMybatisQueryMapper;
import com.yf.usercenter.service.TestMybatisQueryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试mybatis-plus query方法 服务实现类
 * </p>
 *
 * @author yf
 * @since 2022-05-23
 */
@Service
public class TestMybatisQueryServiceImpl extends ServiceImpl<TestMybatisQueryMapper, TestMybatisQuery> implements TestMybatisQueryService {

}
