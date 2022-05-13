package com.yf.ordercenter.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author yf
 * @since 2022-05-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
public class RocketmqTransactionLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 事务id
     */
    @TableField("transaction_Id")
    private String transactionId;

    /**
     * 日志
     */
    private String log;


}
