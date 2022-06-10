package com.yf.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;


/**
 * (SysRole)表实体类
 *
 * @author makejava
 * @since 2022-06-09 14:17:46
 */
@Data
public class SysRole {

         
    @TableId(type = IdType.ASSIGN_ID)
        
    private Integer id;

         
   
        
    private String rolename;

         
   
        
    private String roledesc;
}
