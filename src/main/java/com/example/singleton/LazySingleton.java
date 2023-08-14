package com.example.singleton;

/**
 * 懒汉式（Lazy Initialization）和饿汉式（Eager Initialization）是两种常见的单例模式实现方式。
 * 懒汉式在需要时才创建实例，而饿汉式在类加载时就创建实例。以下是这两种实现方式的示例代码：
 *
 * 在懒汉式中，通过在 getInstance 方法上添加 synchronized 关键字来实现线程安全。但这也带来了性能开销，因为每次调用 getInstance 都会获取锁。
 */
public class LazySingleton {
    private static LazySingleton instance;

    private LazySingleton() {
        // 初始化操作
    }

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
