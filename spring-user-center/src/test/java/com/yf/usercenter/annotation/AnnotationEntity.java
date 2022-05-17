package com.yf.usercenter.annotation;

import java.lang.annotation.Annotation;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-17 18:07
 */
@MyAnnotation(name = "123123")
public class AnnotationEntity {

  public static void main(String[] args) {
    Class clazz = AnnotationEntity.class;
    Annotation[] annotations = clazz.getAnnotations();
    for (int i = 0; i <annotations.length ; i++) {
      if(annotations[i] instanceof MyAnnotation){
        MyAnnotation myAnnotation = (MyAnnotation) annotations[i];
        System.out.println(myAnnotation.name());
      }
    }
  }

}
