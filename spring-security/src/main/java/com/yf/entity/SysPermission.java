package com.yf.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import io.swagger.annotations.ApiModelProperty;


/**
 * (SysPermission)表实体类
 *
 * @author makejava
 * @since 2022-06-09 14:17:43
 */
@Data
public class SysPermission {

         
    @TableId(type = IdType.ASSIGN_ID)
        
    private Integer id;

         
   
        
    private String permname;

         
   
        
    private String permtag;

    /**
     *请求url
     */     
   
    @ApiModelProperty("请求url")    
    private String url;
}
