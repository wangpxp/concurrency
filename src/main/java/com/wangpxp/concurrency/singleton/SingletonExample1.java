package com.wangpxp.concurrency.singleton;

import com.wangpxp.concurrency.annotations.NotThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用的时候加载
 */

@NotThreadSafe
public class SingletonExample1 {

    // 私有构造函数
    private SingletonExample1() {
    }

    // 单例模式
    private static SingletonExample1 instance = null;

    // 静态的工厂方法获取单例
    public static SingletonExample1 getInstance() {
        if (instance == null) {
            instance = new SingletonExample1();
        }
        return instance;
    }
}
