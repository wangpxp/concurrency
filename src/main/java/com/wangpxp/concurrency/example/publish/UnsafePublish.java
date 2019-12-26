package com.wangpxp.concurrency.example.publish;

import com.wangpxp.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;

/**
 * 这是一个不安全发布的类
 * 发布一个对象的意思是指是对象能够在当前作用域之外的代码中使用
 * 在对象构造完成之前发布该对象，被称为逸出
 *
 * 这个类用来发布states不安全，因为所有的调用者都能修改这个数组的内容
 * 数组states已经逸出了他所在的作用域，本应是私有的变量被发布了
 *
 */

@Slf4j
@NotThreadSafe
public class UnsafePublish {

    private String[] states = {"a", "b", "c"};

    private String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish unsafePublish = new UnsafePublish();
        log.info("{}", Arrays.toString(unsafePublish.getStates()));

        unsafePublish.getStates()[0] = "d";
        log.info("{}", Arrays.toString(unsafePublish.getStates()));
    }
}
