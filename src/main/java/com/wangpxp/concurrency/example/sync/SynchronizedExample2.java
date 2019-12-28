package com.wangpxp.concurrency.example.sync;

import com.wangpxp.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@ThreadSafe
//线程安全，所有对象都按顺序执行
public class SynchronizedExample2 {

    // 修饰一个静态代码块，作用范围是整个代码块，作用对象是整个对象
    public static void test1(int j) {
        synchronized (SynchronizedExample2.class) { //这个括号的范围
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    // 修饰一个静态方法,作用范围时整个方法，作用对象是整个对象
    public static synchronized void test2() { //这个括号的范围
        for (int i = 0; i < 10; i++) {
            log.info("tes1 - {}", i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample2 example1 = new SynchronizedExample2();
        SynchronizedExample2 example2 = new SynchronizedExample2();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }
}
