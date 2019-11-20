package com.wb.pattern.singlet.lazy;

/**
 * 懒汉式线程安全
 * @author wangbo
 * @since 2019/10/23 10:30
 */
public class LazySafe {
    private static LazySafe lazy = null;

    private LazySafe(){

    }

    /**
     * 使用双重同步锁
     * @return
     */
    public static LazySafe getInstance(){
        if(lazy == null){
            synchronized (LazySafe.class){
                if(lazy == null){
                    lazy = new LazySafe();
                }
            }
        }
        return lazy;
    }
}
