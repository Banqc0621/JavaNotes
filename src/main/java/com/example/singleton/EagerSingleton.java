package com.example.singleton;

/**
 * 在饿汉式中，实例在类加载时就被创建，因此不存在多线程并发问题。但可能会在程序启动时就创建实例，造成一些性能浪费。
 * 需要注意的是，以上示例都是线程安全的，但懒汉式使用了同步来保证线程安全，可能会影响性能。如果要避免同步开销，
 * 可以考虑使用双重检查锁定（Double-Checked Locking）等方式来优化懒汉式。
 */
public class EagerSingleton {
    private static final EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
        // 初始化操作
    }

    public static EagerSingleton getInstance() {
        return instance;
    }
}
