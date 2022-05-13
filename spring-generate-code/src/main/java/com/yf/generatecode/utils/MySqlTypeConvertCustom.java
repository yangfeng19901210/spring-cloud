package com.yf.generatecode.utils;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-13 9:31
 */
public class MySqlTypeConvertCustom extends MySqlTypeConvert implements ITypeConvert {

  @Override
  public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
    String t = fieldType.toLowerCase();
    if (t.contains("tinyint(1)")) {
      return DbColumnType.INTEGER;
    }
    return super.processTypeConvert(globalConfig, fieldType);
  }
}
