package com.yf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yf.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

/**
 * (SysRole)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-09 14:17:46
 */
@Mapper
public interface SysRoleDao extends BaseMapper<SysRole> {

}
