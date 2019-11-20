package com.wb.pattern.singlet.test;

import com.wb.pattern.singlet.seria.SeriaSinglet;

import java.io.*;

/**
 *  单例序列化测试
 * @author wangbo
 * @since 2019/10/23 14:14
 */
public class SeriaTest {
    public static void main(String[] args) {
        SeriaSinglet s1 = SeriaSinglet.getInstance();

        try {
            ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream("SeriaSinglet.obj"));
            oss.writeObject(s1);
            oss.flush();
            oss.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("SeriaSinglet.obj"));
            SeriaSinglet s2 = (SeriaSinglet) ois.readObject();

            System.out.println(s1);
            System.out.println(s2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
