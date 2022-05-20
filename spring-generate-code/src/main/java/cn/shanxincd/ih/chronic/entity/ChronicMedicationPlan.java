package cn.shanxincd.ih.chronic.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 用药方案信息表
 * </p>
 *
 * @author yf
 * @since 2022-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ChronicMedicationPlan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 方案名称
     */
    private String name;

    /**
     * 用药开始时间
     */
    private Date startTime;

    /**
     * 用药周期
     */
    private String useMedicineCycle;

    /**
     * 达标值
     */
    private String achieveTargetValue;

    /**
     * 方案状态
     */
    private Integer status;

    /**
     * 签约id
     */
    private String chronicSigningId;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标识
     */
    private Integer isDelete;


}
