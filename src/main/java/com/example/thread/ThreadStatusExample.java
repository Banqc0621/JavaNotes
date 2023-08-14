package com.example.thread;

/**
 * @Author: 班前程
 * @Company:北京万相信息
 * @Description:
 * @DateTime: 2023/8/2 14:50
 **/
public class ThreadStatusExample {
    public static void main(String[] args) {
/**
 * 在 Java 中，线程具有不同的状态，这些状态描述了线程在其生命周期中所处的不同阶段。以下是线程的七个主要状态：
 * 1、新建（New）：
 * 当创建一个 Thread 对象时，线程处于新建状态。此时线程对象已被创建，但尚未开始执行线程的 run() 方法。
 *2、就绪（Runnable）：
 * 一旦线程调用了 start() 方法，它就进入了就绪状态。此时线程已经准备好运行，但还没有被调度执行。当线程获得 CPU 时间片后，它将进入运行状态。
 * 3、运行（Running）：
 * 在运行状态下，线程正在执行其 run() 方法中的代码。线程可以从就绪状态进入运行状态，或者从阻塞状态解除阻塞后进入运行状态。
 * 4、阻塞（Blocked）：
 * 当线程等待某个事件（如 I/O 操作或获取锁）时，它会进入阻塞状态。在阻塞状态下，线程不会占用 CPU 时间，直到事件发生。一旦事件发生，线程将重新进入就绪状态等待 CPU 调度。
 * 5、等待（Waiting）：
 * 当线程等待另一个线程通知某个条件时，它会进入等待状态。线程可以通过 Object.wait()、Thread.join() 或者 LockSupport.park() 等方法进入等待状态。等待状态的线程需要等待其他线程显式地唤醒。
 * 6、计时等待（Timed Waiting）：
 * 在计时等待状态下，线程等待一段指定的时间。线程可以通过 Thread.sleep()、Object.wait(long timeout) 或者 Thread.join(long millis) 等方法进入计时等待状态。当指定的时间到达或者事件发生时，线程将重新进入就绪状态。
 * 7、终止（Terminated）：
 * 线程完成了其执行或者因异常而终止时，它将进入终止状态。一旦线程进入终止状态，它将不再可用。
 * 以下是一个简单的示例，展示了线程的不同状态：
 */
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("Thread status: " + thread.getState()); // NEW
        thread.start();
        System.out.println("Thread status: " + thread.getState()); // RUNNABLE

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread status: " + thread.getState()); // TIMED_WAITING

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread status: " + thread.getState()); // TERMINATED
    }
}
