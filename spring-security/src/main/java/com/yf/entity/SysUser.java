package com.yf.entity;


import com.baomidou.mybatisplus.annotation.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


/**
 * (SysUser)表实体类
 *
 * @author makejava
 * @since 2022-06-09 14:17:46
 */
@Data
public class SysUser implements UserDetails {
    @TableId(type = IdType.ASSIGN_ID)
    private Integer id;
    private String username;
    private String realname;
    private String password;
    private Date createDate;
    private Date lastLoginTime;
    private boolean enabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    // 用户所有权限
    private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    public Collection<? extends GrantedAuthority> getAuthorities() {

        return authorities;
    }


}
