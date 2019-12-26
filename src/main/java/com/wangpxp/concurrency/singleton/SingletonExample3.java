package com.wangpxp.concurrency.singleton;

import com.wangpxp.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用的时候加载
 * 加锁性能慢
 */

@ThreadSafe
public class SingletonExample3 {

    // 私有构造函数
    private SingletonExample3() {
    }

    // 单例模式
    private static SingletonExample3 instance = null;

    // 静态的工厂方法获取单例
    public synchronized static SingletonExample3 getInstance() {
        if (instance == null) {
            instance = new SingletonExample3();
        }
        return instance;
    }
}
