package com.wb.pattern.singlet.test;

import com.wb.pattern.singlet.hungry.Hungry;
import com.wb.pattern.singlet.lazy.LazyNotSafe;
import com.wb.pattern.singlet.lazy.LazySafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * 测试线程安全
 *
 * @author wangbo
 * @since 2019/10/22 16:03
 */
public class ThreadSafeTest {
    public static void main(String[] args) {
        final int count = 10000;
        CountDownLatch latch = new CountDownLatch(count);
        long startDate = System.currentTimeMillis();
        Set<LazySafe> set = Collections.synchronizedSet(new HashSet<>());
        for (int i = 0; i < count; i++) {
            new Thread(){
                @Override
                public void run(){
                    LazySafe hungry = LazySafe.getInstance();
                    System.out.println(System.currentTimeMillis() + ":   " + hungry );
                    set.add(hungry);
                    latch.countDown();
                }
            }.start();

        }

        try {
            latch.await();
            System.out.println(set.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("使用毫秒数为:    " + (System.currentTimeMillis() - startDate) );

    }
}
