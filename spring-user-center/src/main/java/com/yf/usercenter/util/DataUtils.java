package com.yf.usercenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-30 11:00
 */
public class DataUtils {

  public static Date strToDate(String dateStr){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    Date date = null;
    try {
      date = sdf.parse(dateStr);
    } catch (ParseException e) {
      e.printStackTrace();
    }
    return date;
  }


}
