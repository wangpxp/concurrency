package com.wangpxp.concurrency.example.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.wangpxp.concurrency.annotations.ThreadSafe;
import lombok.extern.slf4j.Slf4j;

// Colletions内部定义了不可变方法unmodifiable方法，将引用类型变为不可变对象
@Slf4j
@ThreadSafe
public class ImmutableExample3 {

    private final static ImmutableList<Integer> list = ImmutableList.of(1, 2, 3);

    private final static ImmutableSet set = ImmutableSet.of(1, 2, 3);

    private final static ImmutableMap<Integer, Integer> map = ImmutableMap.of(1, 2, 3, 4);

    private final static ImmutableMap<Integer, Integer> map2 = ImmutableMap.<Integer, Integer>builder()
            .put(1, 2).put(3, 4).put(5, 6).build();

    public static void main(String[] args) {
        log.info("{}", map2.get(1));
    }
}
