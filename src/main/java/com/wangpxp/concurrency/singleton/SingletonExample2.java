package com.wangpxp.concurrency.singleton;

import com.wangpxp.concurrency.annotations.ThreadSafe;

/**
 * 饿汉模式
 * 单例实例在类装载的时候进行创建
 * 如果操作过程中存在很多处理，则会对性能有很大的影响
 */

@ThreadSafe
public class SingletonExample2 {

    // 私有构造函数
    private SingletonExample2() {
    }

    // 单例模式
    private static SingletonExample2 instance = new SingletonExample2();

    // 静态的工厂方法获取单例
    public static SingletonExample2 getInstance() {
        return instance;
    }
}
