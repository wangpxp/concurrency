package com.wangpxp.concurrency.example.sync;

import com.wangpxp.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@ThreadSafe
//线程安全，但是对象和对象之间互不干扰
public class SynchronizedExample1 {

    // 修饰一个代码块，作用范围是整个代码块，作用对象是调用对象
    public void test1(int j) {
        synchronized (this) { //这个括号的范围
            for (int i = 0; i < 10; i++) {
                log.info("test1 {} - {}", j, i);
            }
        }
    }

    // 修饰一个方法,作用范围时整个方法，作用对象是调用对象
    public synchronized void test2() { //这个括号的范围
        for (int i = 0; i < 10; i++) {
            log.info("tes1 - {}", i);
        }
    }

    public static void main(String[] args) {
        SynchronizedExample1 example1 = new SynchronizedExample1();
        SynchronizedExample1 example2 = new SynchronizedExample1();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() -> {
            example1.test1(1);
        });
        executorService.execute(() -> {
            example2.test1(2);
        });
    }
}
