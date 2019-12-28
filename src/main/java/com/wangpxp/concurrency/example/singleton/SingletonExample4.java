package com.wangpxp.concurrency.example.singleton;

import com.wangpxp.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用的时候加载
 */

@ThreadSafe
public class SingletonExample4 {

    // 私有构造函数
    private SingletonExample4() {
    }

    // 单例模式
    private volatile static SingletonExample4 instance = null;

    // 静态的工厂方法获取单例
    public static SingletonExample4 getInstance() {
        if (instance == null) { // 双重检测机制
            synchronized (SingletonExample4.class) {
                if (instance == null) {
                    instance = new SingletonExample4();
                } //由于重排序的原因，现在也还不是线程安全的，要在变量加入volatile关键字
            }
        }
        return instance;
    }
}
