package com.example.thread;

/**
 * @Author: 班前程
 * @Company:北京万相信息
 * @Description:
 * @DateTime: 2023/8/4 17:20
 **/

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 方式四：使用线程池
 * 线程池好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *
 * 核心参数：
 *
 * corePoolSize：核心池的大小
 * maximumPoolSize：最大线程数
 * keepAliveTime：线程没有任务时最多保持多长时间后会终止
 * 步骤：
 * 1.以方式二或方式三创建好实现了Runnable接口的类或实现Callable的实现类
 * 2.实现run或call方法
 * 3.创建线程池
 * 4.调用线程池的execute方法执行某个线程，参数是之前实现Runnable或Callable接口的对象
 *
 * 版权声明：本文为CSDN博主「强强爱java」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_43824267/article/details/112706385
 */


/**
 * 线程池七大参数：
 * 一、corePoolSize 线程池核心线程大小
 * 线程池中会维护一个最小的线程数量，即使这些线程处理空闲状态，他们也不会被销毁，除非设置了allowCoreThreadTimeOut。
 * 这里的最小线程数量即是corePoolSize。任务提交到线程池后，首先会检查当前线程数是否达到了corePoolSize，如果没有达到的话，则会创建一个新线程来处理这个任务。
 *
 * 二、maximumPoolSize 线程池最大线程数量
 * 当前线程数达到corePoolSize后，如果继续有任务被提交到线程池，会将任务缓存到工作队列（后面会介绍）中。如果队列也已满，则会去创建一个新线程来出来这个处理。线程池不会无限制的去创建新线程，它会有一个最大线程数量的限制，这个数量即由maximunPoolSize指定。
 *
 * 三、keepAliveTime 空闲线程存活时间
 * 一个线程如果处于空闲状态，并且当前的线程数量大于corePoolSize，那么在指定时间后，这个空闲线程会被销毁，这里的指定时间由keepAliveTime来设定
 *
 * 四、unit 空闲线程存活时间单位
 * keepAliveTime的计量单位
 *
 * 五、workQueue 工作队列
 *新任务被提交后，会先进入到此工作队列中，任务调度时再从队列中取出任务。jdk中提供了四种工作队列：
 *
 * 六、threadFactory 线程工厂
 * 创建一个新线程时使用的工厂，可以用来设定线程名、是否为daemon线程等等
 *
 * 七、handler 拒绝策略
 * 当工作队列中的任务已到达最大限制，并且线程池中的线程数量也达到最大限制，这时如果有新任务提交进来，该如何处理呢。
 * 这里的拒绝策略，就是解决这个问题的，jdk中提供了4中拒绝策略：
 * ————————————————
 * 版权声明：本文为CSDN博主「ye17186」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/ye17186/article/details/89467919
 */
public class ThreadPool {
    public static void main(String[] args) {
        //1. 提供指定线程数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        System.out.println(executorService.getClass());
        //ThreadPoolExecutor executorService1 = (ThreadPoolExecutor)executorService;
        //自定义线程池的属性
        //        service1.setCorePoolSize(15);
        //        service1.setKeepAliveTime();
        executorService.execute(new ThreadRunnableTest1());//是用于Runnable
        executorService.execute(new ThreadRunnableTest2());//适用于Runnale
        //关闭线程池
        executorService.shutdown();
    }
}


class ThreadRunnableTest1 implements Runnable{
    @Override
    public void run() {
        //遍历100以内的偶数
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class ThreadRunnableTest2 implements Runnable{
    @Override
    public void run() {
        //遍历100以内的奇数
        for (int i = 0; i < 100; i++) {
            if (i % 2 != 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}