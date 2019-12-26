package com.wangpxp.concurrency.singleton;

import com.wangpxp.concurrency.annotations.Recommend;
import com.wangpxp.concurrency.annotations.ThreadSafe;

/**
 * 枚举模式：最安全
 * 相比于懒汉模式安全性更好
 * 相比于饿汉模式在实际调用才初始化
 */

@ThreadSafe
@Recommend
public class SingletonExample6 {

    // 私有构造函数
    private SingletonExample6() {
    }

    // 单例模式
    private static SingletonExample6 instance = null;

    // 静态的工厂方法获取单例
    public static SingletonExample6 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    private enum Singleton {
        INSTANCE;

        private SingletonExample6 instance;

        //JVM保证这个方法绝对只调用一次
        Singleton() {
            instance = new SingletonExample6();
        }

        public SingletonExample6 getInstance() {
            return instance;
        }
    }
}
