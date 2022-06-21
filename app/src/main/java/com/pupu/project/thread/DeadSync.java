package com.pupu.project.thread;


import com.pupu.question.R;

public class DeadSync {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void run() {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock1) {
                    System.out.println("t1 run");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock2) {
                        System.out.println("fjvndfn");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock2) {
                    System.out.println("t2 run");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (lock1) {
                        System.out.println("执行。。。");
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
