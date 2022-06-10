package com.yf.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yf.entity.SysPermission;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

/**
 * (SysPermission)表数据库访问层
 *
 * @author makejava
 * @since 2022-06-09 14:17:42
 */
@Mapper
public interface SysPermissionDao extends BaseMapper<SysPermission> {

  List<SysPermission> getAllPers();

}
