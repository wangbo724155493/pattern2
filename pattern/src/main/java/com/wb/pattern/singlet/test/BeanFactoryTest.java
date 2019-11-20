package com.wb.pattern.singlet.test;

import com.wb.pattern.singlet.register.BeanFactory;
import javafx.beans.binding.ObjectExpression;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * @author wangbo
 * @since 2019/10/25 11:45
 */
public class BeanFactoryTest {
    public static void main(String[] args) {
        System.out.println(BeanFactory.getBean("com.wb.pattern.singlet.test.SeriaTest"));
        System.out.println(BeanFactory.getBean("com.wb.pattern.singlet.test.SeriaTest"));
        int count = 1000;
        CountDownLatch latch = new CountDownLatch(count);
        Set<Object> set = new HashSet<>();
        for(int i=0;i<count;i++){
            new Thread(){
                @Override
                public void run() {
                    Object obj = BeanFactory.getBean("com.wb.pattern.singlet.test.SeriaTest");
                    System.out.println( Thread.currentThread().getName() + " :" + obj);
                    set.add(obj);
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
    }
}