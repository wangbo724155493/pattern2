package com.wb.pattern.singlet.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *  注册式单例
 * @author wangbo
 * @since 2019/10/25 11:39
 */
public class BeanFactory {

    private static final Map<String,Object> ioc = new ConcurrentHashMap<>();

    private BeanFactory(){

    }

    public static Object getBean(String className){
        if(!ioc.containsKey(className)){
            Object obj = null;
            try{
                obj = Class.forName(className).newInstance();
                ioc.put(className,obj);
            }catch (Exception e){
                e.printStackTrace();
            }
            return obj;
        }else{
            return ioc.get(className);
        }
    }
}
