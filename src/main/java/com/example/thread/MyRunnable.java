package com.example.thread;

/**
 * @Author: 班前程
 * @Company:北京万相信息
 * @Description:
 * @DateTime: 2023/8/4 16:36
 **/

/**
 * 方式二：实现Runnable接口
 * 步骤：
 * 1.创建一个实现了Runnable接口的类
 * 2.实现类去实现Runnable中的抽象方法：run()
 * 3.创建实现类的对象
 * 4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5.通过Thread类的对象调用start()
 * ① 启动线程
 * ②调用当前线程的run()–>调用了Runnable类型的target的run()
 * ————————————————
 * 版权声明：本文为CSDN博主「强强爱java」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_43824267/article/details/112706385
 */

/**
 * 方式一和方式二的比较：
 *
 * 开发中优先选择实现Runnable接口的方式
 * 原因：
 * （1）实现的方式没有类的单继承性的局限性
 * （2）实现的方式更适合来处理多个线程有共享数据的情况
 * 相同点：两种方式都需要重写run(),将线程要执行的逻辑声明在run()中
 */

class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
        }
    }
}

class ThreadTest2 {
    public static void main(String[] args) {
        //1、创建实现类的对象
        MyRunnable myRunnable = new MyRunnable();

        //将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread thread = new Thread(myRunnable);
        thread.setName("线程1");

        //通过Thread类的对象调用start()：启动线程，调用当前线程的run()-->调用了Runnable类型的target的run()
        thread.start();

        Thread thread1 = new Thread(myRunnable);
        thread1.setName("线程2");
        thread1.start();
    }

}

