package com.yf.usercenter.thread;

import org.apache.ibatis.javassist.runtime.Inner;
import org.junit.Test;

/**
 * 测试线程创建方式类
 * @author yangfeng
 * @version 1.0
 * @date 2022-05-30 13:59
 */
public class TestThreadCreate {

  //继承Thread 方式创建线程
  @Test
  public void testCreThreadByExTh(){
    System.out.println(Thread.currentThread().getName());
    System.out.println("-----创建线程开始---");
    CreateThread thread = new CreateThread();
    System.out.println("start方法启动线程");
    System.out.println(thread.getName());
    thread.start();
    System.out.println("----线程创建结束------");
  }
  //实现Runnable接口重写run方法创建线程
  @Test
  public void testCreThreadByImpRun(){
    System.out.println("------开始创建线程-----");
    RunnableThread rt = new RunnableThread();
    Thread th = new Thread(rt,"runnable线程--0");
    System.out.println("------启动线程，等待获取cpu执行-----");
    th.start();
    System.out.println("----线程创建结束------");

  }

  //匿名内部类的方式创建多线程
  @Test
  public void testAnonymousInnerClass(){
    System.out.println("-------多线程创建开始-------");
    Thread thread = new Thread(
        new Runnable() {
          @Override
          public void run() {
            for (int i=0;i<10;i++){
              System.out.println("i="+i);
            }
          }
        }
    );
    thread.start();
    System.out.println("-------多线程创建结束-------");
  }



}
