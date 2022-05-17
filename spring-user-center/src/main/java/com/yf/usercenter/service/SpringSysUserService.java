package com.yf.usercenter.service;

import com.yf.usercenter.model.SpringSysUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yf
 * @since 2022-05-16
 */
public interface SpringSysUserService extends IService<SpringSysUser> {
  /***
   * @describe  根据id查询数据库用户信息
   * @author yangfeng
   * @date 2022-05-17 14:03:24
   * @param id
   * @return
   **/
  SpringSysUser getById(int id);

}
