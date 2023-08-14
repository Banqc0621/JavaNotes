package com.example.singleton;

/**
 * @Author: 班前程
 * @Company:北京万相信息
 * @Description:
 * @DateTime: 2023/8/10 14:26
 **/

/**
 * 当提到现代Java版本中的单例模式实现时，静态内部类单例和枚举单例是推荐的方式之一，它们都能够保证线程安全且懒加载。以下是这两种实现方式的示例代码：
 */
public class InnerClassSingleton {
    private InnerClassSingleton() {
        // 初始化操作
    }

    private static class SingletonHolder {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}


