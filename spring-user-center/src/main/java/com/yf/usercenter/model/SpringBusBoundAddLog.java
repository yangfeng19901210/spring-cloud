package com.yf.usercenter.model;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用户新增积分记录表
 * </p>
 *
 * @author yf
 * @since 2022-05-16
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class SpringBusBoundAddLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 本次新增积分
     */
    private Integer bound;

    /**
     * 添加时间
     */
    private Date createTime;


}
