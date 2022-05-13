package com.yf.generatecode.utils;

import lombok.Builder;
import lombok.Data;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-13 10:05
 */
@Data
@Builder
public class CodePath {
  //项目根目录
  private String projectRootPath;
  //项目基础包名
  private String basePackage;

}
