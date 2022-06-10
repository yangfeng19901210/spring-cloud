package com.yf.usercenter.thread;

/**
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-30 14:02
 */
public class CreateThread extends Thread{

  @Override
  public void run() {
    for (int i=0;i<10;i++){
      System.out.println("i="+i);
    }
  }
}
