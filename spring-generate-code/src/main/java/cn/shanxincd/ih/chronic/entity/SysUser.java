package cn.shanxincd.ih.chronic.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yf
 * @since 2022-06-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String username;

    private String realname;

    private String password;

    private Date createDate;

    private Date lastLoginTime;

    private Integer enabled;

    private Integer accountNonExpired;

    private Integer accountNonLocked;

    private Integer credentialsNonExpired;


}
