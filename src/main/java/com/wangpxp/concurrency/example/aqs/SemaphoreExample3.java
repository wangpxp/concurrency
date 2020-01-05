package com.wangpxp.concurrency.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

@Slf4j
public class SemaphoreExample3 {
    private final static int threadCount = 200;

    public static void main(String[] args) throws InterruptedException {

        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3); //同时允许3个线程执行

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            exec.execute(()-> {
                try {
                    if (semaphore.tryAcquire()) { //尝试获取一个许可
                        test(threadNum);
                        semaphore.release(); // 释放1个许可
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                }
            });
        }
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws InterruptedException {
        log.info("{}", threadNum);
        Thread.sleep(1000);
    }
}