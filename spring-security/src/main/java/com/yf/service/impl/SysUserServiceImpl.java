package com.yf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yf.dao.SysUserDao;
import com.yf.entity.SysUser;
import com.yf.service.SysUserService;
import org.springframework.stereotype.Service;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2022-06-09 14:17:46
 */
@Service("sysUserService")
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {

}
