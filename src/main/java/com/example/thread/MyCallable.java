package com.example.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: 班前程
 * @Company:北京万相信息
 * @Description:
 * @DateTime: 2023/8/4 16:49
 **/

/**
 * 方式三：实现Callable接口
 * 步骤：
 * 1.创建一个实现Callable的实现类
 * 2.实现call方法，将此线程需要执行的操作声明在call()中
 * 3.创建Callable接口实现类的对象
 * 4.将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
 * 5.将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
 * 6.获取Callable中call方法的返回值
 *
 * 实现Callable接口的方式创建线程的强大之处
 *
 * call()可以有返回值的
 * call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * Callable是支持泛型的
 * ————————————————
 * 版权声明：本文为CSDN博主「强强爱java」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
 * 原文链接：https://blog.csdn.net/weixin_43824267/article/details/112706385
 */

/**
 * 此类提供 Future 的基本实现，其中包含用于启动和取消计算、查询计算是否完成以及检索计算结果的方法。
 * 只有在计算完成后才能检索结果;如果计算尚未完成，Get 方法将阻塞。计算完成后，无法重新启动或取消计算（除非使用 runAndReset 调用计算）。
 * FutureTask 可用于包装 Callable 或 Runnable 对象。由于 FutureTask 实现了 Runnable，因此可以将 FutureTask 提交给执行器执行。
 * 除了用作独立类之外，此类还提供受保护的功能，这些功能在创建自定义任务类时可能很有用。自： 1.5 作者： Doug Lea
 *
 * FutureTask实现了RunnableFuture,
 * RunnableFuture接口多继承了Runnable和Future
 */
public class MyCallable implements Callable {
    @Override
    public Object call() {
        int sum = 0;
        //把100以内的偶数相加
        for (int i = 1; i <= 100; i++) {
            if(i % 2 == 0) {
                System.out.println(i);
                sum += i;
            }
        }
        return sum;
    }
}

class ThreadTest3 {
    public static void main(String[] args) {
        //创建Callable接口实现类的对象
        /**
         * 返回结果并可能引发异常的任务。实现者定义一个没有称为调用的参数的方法。
         * Callable 接口类似于 Runnable，因为两者都是为实例可能由另一个线程执行的类设计的。
         * 但是，可运行对象不返回结果，并且无法引发已检查的异常。类包含用于从其他常见形式转换为可调用类的实用工具方法。
         * 自： 1.5 请参阅： Executor 作者： Doug Lea 类型形参： <V> – 方法调用的结果类型
         */
        MyCallable myCallable = new MyCallable();
        //将此Callable接口实现类的对象作为传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask futureTask = new FutureTask<>(myCallable);
        //将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()
        new Thread(futureTask).start();

        try {
            //获取Callable中call方法的返回值
            //get()返回值纪委FutureTaskg构造器参数Callable实现类重写的Call()的返回值
            Object sum = futureTask.get();
            System.out.println("总和为：" + sum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
