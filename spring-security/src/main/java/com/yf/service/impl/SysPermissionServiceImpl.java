package com.yf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yf.dao.SysPermissionDao;
import com.yf.entity.SysPermission;
import com.yf.service.SysPermissionService;
import org.springframework.stereotype.Service;

/**
 * (SysPermission)表服务实现类
 *
 * @author makejava
 * @since 2022-06-09 14:17:45
 */
@Service("sysPermissionService")
public class SysPermissionServiceImpl extends ServiceImpl<SysPermissionDao, SysPermission> implements SysPermissionService {

}
