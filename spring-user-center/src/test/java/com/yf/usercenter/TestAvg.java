package com.yf.usercenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-24 10:51
 */
public class TestAvg {


  @Test
  public void testAvg() {
    List<REcord> list = new ArrayList<REcord>();

    REcord rEcord = new REcord();
    rEcord.setDate("2022-01-01");
    rEcord.setValue(5.00);

    REcord rEcord1 = new REcord();
    rEcord1.setDate("2022-01-02");
    rEcord1.setValue(7.00);

    REcord rEcord2 = new REcord();
    rEcord2.setDate("2022-01-03");
    rEcord2.setValue(11.00);

    REcord rEcord3 = new REcord();
    rEcord3.setDate("2022-01-04");
    rEcord3.setValue(19.00);

    REcord rEcord4 = new REcord();
    rEcord4.setDate("2022-01-05");
    rEcord4.setValue(23.00);

    REcord rEcord5 = new REcord();
    rEcord5.setDate("2022-01-06");
    rEcord5.setValue(96.00);

    REcord rEcord6 = new REcord();
    rEcord6.setDate("2022-01-07");
    rEcord6.setValue(77.00);
    list.add(rEcord);
    list.add(rEcord1);
    list.add(rEcord2);
    list.add(rEcord3);
//    list.add(rEcord4);
//    list.add(rEcord5);
//    list.add(rEcord6);
    System.out.println(list);
    double v = list.stream().filter(
        r -> r.getDate().compareTo("2022-01-01") >= 0 && r.getDate().compareTo("2022-01-05") <= 0)
        .mapToDouble(REcord::getValue).average().orElse(0d);
    System.out.println(v);
  }


}
