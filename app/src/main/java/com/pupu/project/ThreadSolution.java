package com.pupu.project;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.LockSupport;

public class ThreadSolution {

    Thread t1;
    Thread t2;

    // 使用门闩 来完成某个线程先执行
    private CountDownLatch latch=new CountDownLatch(1);

    public void printNum() {
        final int[] num = {0};
        Object o = new Object();

        t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
//                    System.out.println("t1:" + String.valueOf(++num[0]));
//                    LockSupport.unpark(t2);
//                    LockSupport.park();
                synchronized (o) {
                    while (num[0] < 100) {
                        System.out.println("t1:" + String.valueOf(++num[0]));
                        o.notifyAll();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    o.notify();
                }
            }
        }, "t1");

        t2 = new Thread(new Runnable() {
            @Override
            public void run() {

//                    LockSupport.park();//阻塞
//                    System.out.println("t2:"+String.valueOf(++num[0]));
//                    LockSupport.unpark(t1);//唤醒某个线程
                synchronized (o) {
                    while (num[0] < 100) {
                        System.out.println("t2:" + String.valueOf(++num[0]));
                        latch.countDown();
                        o.notifyAll();
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    o.notify(); //必须，不然有线程wait中
                }

            }
        }, "t2");

        t1.start();
        t2.start();
    }
}
