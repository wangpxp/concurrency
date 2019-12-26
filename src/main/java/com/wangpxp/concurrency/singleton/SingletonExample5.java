package com.wangpxp.concurrency.singleton;


import com.wangpxp.concurrency.annotations.ThreadSafe;

/**
 * 懒汉模式
 * 单例实例在第一次使用的时候加载
 */

@ThreadSafe
public class SingletonExample5 {

    // 私有构造函数
    private SingletonExample5() {
    }

    // 单例模式
    private static SingletonExample5 instance = null;

    //通过静态块，要注意放在变量定义之后
    static {
        instance = new SingletonExample5();
    }

    // 静态的工厂方法获取单例
    public static SingletonExample5 getInstance() {
        return instance;
    }
}
