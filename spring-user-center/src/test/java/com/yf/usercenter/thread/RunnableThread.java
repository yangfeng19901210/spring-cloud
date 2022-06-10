package com.yf.usercenter.thread;

/**
 * 线程创建方式二：实现 Runnable接口并重写run方法
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-30 15:40
 */
public class RunnableThread implements Runnable {

  @Override
  public void run() {
    for (int i=0;i<10;i++){
      System.out.println("i="+i);
    }
  }
}
