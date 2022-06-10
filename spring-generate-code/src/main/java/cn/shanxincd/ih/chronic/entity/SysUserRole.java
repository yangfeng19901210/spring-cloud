package cn.shanxincd.ih.chronic.entity;

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
public class SysUserRole implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer roleId;


}
