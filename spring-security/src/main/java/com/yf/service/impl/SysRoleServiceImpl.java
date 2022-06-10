package com.yf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yf.dao.SysRoleDao;
import com.yf.entity.SysRole;
import com.yf.service.SysRoleService;
import org.springframework.stereotype.Service;

/**
 * (SysRole)表服务实现类
 *
 * @author makejava
 * @since 2022-06-09 14:17:46
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleDao, SysRole> implements SysRoleService {

}
