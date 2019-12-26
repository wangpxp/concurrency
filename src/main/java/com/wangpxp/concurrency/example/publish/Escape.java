package com.wangpxp.concurrency.example.publish;

import com.wangpxp.concurrency.annotations.NotRecommend;
import com.wangpxp.concurrency.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * 内部类实例里包含了对封装实例的隐含使用
 * 在构造函数期间启动了一个新的线程，this隐式逸出
 * 一个已经发布的对象能够通过非私有的变量引用和方法到达其他的对象，那么这些对象也都会被发布
 *
 * Escape发布InnerClass的时候，也隐含发布了Escape实例本身
 */

@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            log.info("{}", Escape.this.thisCanBeEscape);
        }
    }
}
