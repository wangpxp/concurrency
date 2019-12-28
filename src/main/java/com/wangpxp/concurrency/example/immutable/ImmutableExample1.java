package com.wangpxp.concurrency.example.immutable;

import com.wangpxp.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

// final定义不可变的基本类型，但对于引用对象来说，不可变的是对象，对象内部是可以改变的
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {

    private static final int a = 1;

    private static final String b = "2";

    private static final Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);
    }

    public static void main(String[] args) {
        map.put(1, 3);
        log.info("{}", map.get(1));
    }
}
