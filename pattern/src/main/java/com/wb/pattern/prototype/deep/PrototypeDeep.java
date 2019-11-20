package com.wb.pattern.prototype.deep;

import java.io.*;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

/**
 *  原型模式深度克隆
 *
 * @author wangbo
 * @since 2019/10/25 15:59
 */
public class PrototypeDeep implements Cloneable,Serializable{
    private String name;

    private Person person;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return this.deepClone();
    }

    /**
     * 深度克隆 通过序列化和反序列化
     * @return
     */
    public Object deepClone(){
        try {
            ByteArrayOutputStream aos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(aos);
            oos.writeObject(this);

            ByteArrayInputStream ais = new ByteArrayInputStream(aos.toByteArray());
            ObjectInputStream bis = new ObjectInputStream(ais);

            bis.close();
            oos.close();
            return bis.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PrototypeDeep obj1 = new PrototypeDeep();
        obj1.setName("张三");
        obj1.setPerson(new Person("哈哈哈哈"));
        PrototypeDeep obj2 = (PrototypeDeep) obj1.clone();

        System.out.println(obj1);
        System.out.println(obj2);
        System.out.println("=========================");
        // 打印地址值
        System.out.println(obj1.getPerson());
        System.out.println(obj2.getPerson());
        System.out.println(~2);


        try {
            Class<?> clazz = Class.forName("com.wb.pattern.prototype.deep.Person");
            // 获取访问修饰符
            System.out.println(Modifier.toString(clazz.getMethods()[0].getModifiers()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
