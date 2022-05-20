package cn.shanxincd.ih.chronic.entity;

import java.util.Date;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 方案对应的药品清单表
 * </p>
 *
 * @author yf
 * @since 2022-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ChronicMedicationPlanDrug implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private String id;

    /**
     * 用药方案id
     */
    private String chronicMedicationPlanId;

    /**
     * 药品编号
     */
    private String drugsNo;

    /**
     * 药品名称
     */
    private String drugsName;

    /**
     * 药品通用名
     */
    private String drugsCommonName;

    /**
     * 药品类别
     */
    private String drugsType;

    /**
     * 药品剂型
     */
    private String drugDosageForm;

    /**
     * 每次剂量
     */
    private String dose;

    /**
     * 频次
     */
    private String frequency;

    /**
     * 提醒规则
     */
    private String remindRule;

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
