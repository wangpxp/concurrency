package com.wangpxp.concurrency.example.immutable;

import com.wangpxp.concurrency.annotations.NotThreadSafe;
import com.wangpxp.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Colletions内部定义了不可变方法unmodifiable方法，将引用类型变为不可变对象
@Slf4j
@ThreadSafe
public class ImmutableExample2 {

    private static Map<Integer, Integer> map = new HashMap<>();

    static {
        map.put(1, 2);
        map.put(2, 3);
        map.put(3, 4);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 3);
        log.info("{}", map.get(1));
    }
}
