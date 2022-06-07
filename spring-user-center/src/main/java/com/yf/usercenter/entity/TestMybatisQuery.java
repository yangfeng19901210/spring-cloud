package com.yf.usercenter.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * <p>
 * 测试mybatis-plus query方法
 * </p>
 *
 * @author yf
 * @since 2022-05-23
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestMybatisQuery implements Serializable {



    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private String sex;

    /**
     * 薪资
     */
    private Double salary;

    public TestMybatisQuery(String name, Integer age, String sex, Double salary) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.salary = salary;
    }
}
