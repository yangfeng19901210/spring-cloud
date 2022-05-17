package com.yf.usercenter.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-17 17:51
 * @Target 定义注解作用的位置 ：注解的作用位置 : 包 , 类 , 成员变量 , 方法 , 方法参数 , 局部变量 , 6 66 个作用位置 ;
 * @Retention 描述注解被保留的阶段
 * @Documented 描述 注解 是否需要被抽取到文档中 , 在使用 javadoc 命令生成文档时 , 该 注解 是否生成到文档中
 * @Inherited : 描述 注解 是否被子类继承 , 如果添加了该注解 , 则子类会自动继承父类的注解
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface MyAnnotation {

  String name() default "";

}
