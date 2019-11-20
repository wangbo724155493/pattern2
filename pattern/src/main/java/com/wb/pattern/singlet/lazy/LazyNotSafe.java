package com.wb.pattern.singlet.lazy;

/**
 *  懒汉式线程不安全
 * @author wangbo
 * @since 2019/10/23 10:07
 */
public class LazyNotSafe {

    private static LazyNotSafe lazy = null;

    private LazyNotSafe(){

    }

    public static LazyNotSafe getInstance(){
        if(lazy == null){
            lazy = new LazyNotSafe();
        }
        return lazy;
    }

}
