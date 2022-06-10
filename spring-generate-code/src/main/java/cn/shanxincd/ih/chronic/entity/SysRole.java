package cn.shanxincd.ih.chronic.entity;

import com.baomidou.mybatisplus.annotation.TableField;
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
public class SysRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @TableField("roleName")
    private String roleName;

    @TableField("roleDesc")
    private String roleDesc;


}
