package com.yf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yf.dao.SysUserRoleDao;
import com.yf.entity.SysUserRole;
import com.yf.service.SysUserRoleService;
import org.springframework.stereotype.Service;

/**
 * (SysUserRole)表服务实现类
 *
 * @author makejava
 * @since 2022-06-09 14:17:46
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleDao, SysUserRole> implements SysUserRoleService {

}
