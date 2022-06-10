package com.yf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yf.entity.SysPermission;
import com.yf.entity.SysUser;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (SysUser)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-09 14:17:46
 */
@Mapper
public interface SysUserDao extends BaseMapper<SysUser> {

  SysUser getUserByUserName(String userName);

  List<SysPermission> getPermissionsByUserName(String userName);

}
