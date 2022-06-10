package com.yf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yf.entity.SysUserRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * (SysUserRole)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-09 14:17:46
 */
@Mapper
public interface SysUserRoleDao extends BaseMapper<SysUserRole> {

}
