package com.wb.pattern.singlet.seria;

import java.io.Serializable;

/**
 * @author wangbo
 * @since 2019/10/23 14:18
 */
public class SeriaSinglet implements Serializable{

    private static SeriaSinglet singlet = new SeriaSinglet();

    private SeriaSinglet(){

    }

    public static SeriaSinglet getInstance(){
        return singlet;
    }

    /**
     * 防止序列化对单例的破坏
     * @return
     */
    public Object readResolve(){
        return singlet;
    }

}
