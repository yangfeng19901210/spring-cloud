package com.yf.ordercenter.enumeration;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public enum ArticleStatus {
  DRAFT(1,"草稿"),RELEASE(2,"已发布"),REVIEWED(3,"已审核"),AUDIT_REJECT(4,"审核拒绝");
  private int index;
  private String name;

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static String getName(int index) {
    for (ArticleStatus c : ArticleStatus.values()) {
      if (c.getIndex() == index) {
        return c.name;
      }
    }
    return null;
  }
}
