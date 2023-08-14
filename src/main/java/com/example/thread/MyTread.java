package com.example.thread;

/**
 * @Author: 班前程
 * @Company:北京万相信息
 * @Description:
 * @DateTime: 2023/8/4 14:55
 **/

/**
 * 方式一：继承于Thread类
 * 步骤：
 * 1.创建一个继承于Thread类的子类
 * 2.重写Thread类的run() --> 将此线程执行的操作声明在run()中
 * 3.创建Thread类的子类的对象
 * 4.通过此对象调用start()执行线程
 */
public class MyTread extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + " : " + i);
            }
        }
    }
}


class ThreadTest1 {
    public static void main(String[] args) {

        MyTread myTread = new MyTread();
        myTread.start();

        MyTread myTread1 = new MyTread();
        myTread1.start();

        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i + "**********main()*************");
            }
        }
    }
}
