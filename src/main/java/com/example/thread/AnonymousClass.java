package com.example.thread;

/**
 * @Author: 班前程
 * @Company:北京万相信息
 * @Description:
 * @DateTime: 2023/8/4 17:42
 **/
public class AnonymousClass {
    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                // 线程需要执行的任务代码
                System.out.println("子线程开始启动....");
                for (int i = 0; i < 30; i++) {
                    System.out.println("run i:" + i);
                }
            }
        }).start();


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                // 线程需要执行的任务代码
                System.out.println("子线程开始启动....");
                for (int i = 0; i < 30; i++) {
                    System.out.println("run i:" + i);
                }
            }
        });
        thread.start();
    }
}
