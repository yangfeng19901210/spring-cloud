package com.yf.usercenter.thread;

/**
 * 线程死锁问题
 */
public class DeadLock {
    public static void main(String[] args) {
        //创建两个锁对象
        Object lock1 = new Object();
        Object lock2 = new Object();

        //创建子线程
        /*
        线程1：①先获得锁1 ②休眠1s，让线程2获得锁2 ③线程1尝试获取锁2 线程2同理
         */
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                //线程1业务逻辑
                synchronized(lock1){
                    System.out.println("线程1得到了锁子1");
                    try {
                        //休眠1s，让线程2先得到锁2
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程1尝试获取锁2...");
                    synchronized(lock2){
                        System.out.println("线程1获得了锁2!");
                    }
                }
            }
        },"线程1");


        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                //线程2业务逻辑
                synchronized(lock1){
                    System.out.println("线程2得到了锁子2");
                    try {
                //休眠1s，让线程1先得到锁1；因为线程是并发执行我们不知道谁先执行
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("线程2尝试获取锁1...");
                    synchronized(lock2){
                        System.out.println("线程2获得了锁1");
                    }
                }
            }
        },"线程2");
        thread2.setPriority(Thread.MAX_PRIORITY);
        thread1.start();
        thread2.start();

    }
}

