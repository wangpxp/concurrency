package com.wangpxp.concurrency.example.syncContainer;

import com.wangpxp.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Vector;

@Slf4j
@NotThreadSafe
public class VectorExample2 {

    //vector的每个操作只有一个线程能访问它，但是不是只能由一个线程访问vector
    //一个线程如果要get(9)，另一个线程移除了，就会发生数组越界
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < vector.size(); i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        vector.get(i);
                    }
                }
            };
            thread1.start();
            thread2.start();
        }
    }
}