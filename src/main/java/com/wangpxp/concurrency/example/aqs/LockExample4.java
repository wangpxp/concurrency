package com.wangpxp.concurrency.example.aqs;

import com.wangpxp.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.StampedLock;

@Slf4j
@ThreadSafe
public class LockExample4 {

    //请求总数
    public static int clientTotal = 5000;

    // 同时并发执行的线程数
    public static int threadTotal = 200;

    public static int count = 0;

    private final static StampedLock lock = new StampedLock();

    public static void main(String[] args) throws InterruptedException {
        // 定义线程池
        ExecutorService executorService = Executors.newCachedThreadPool();
        // 定义信号量，信号量的数量和线程数相同
        final Semaphore semaphore = new Semaphore(threadTotal);
        // 定义CountDownLatch,CountDownLatch可以阻塞线程，在一个特定条件满足后继续执行。
        //
        // CountDownLatch能够使一个线程在等待另外一些线程完成各自工作之后，再继续执行。使用一个计数器进行实现。
        final CountDownLatch countDownLatch = new CountDownLatch(clientTotal);

        for (int i = 0; i < clientTotal; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire(); // 信号量执行
                    add();
                    semaphore.release(); // 信号量释放
                } catch (InterruptedException e) {
                    log.error("exception", e);
                }
                countDownLatch.countDown(); //countDownLatch计数器减一
            });
        }
        countDownLatch.await(); // 计数器减到0， countDownLatch的await线程可以被唤醒，在此之前等待
        log.info("count:{}", count);
    }

    private static void add() {
        long stamp = lock.writeLock();
        try {
            count++;
        } finally {
            lock.unlock(stamp);
        }

    }
}
