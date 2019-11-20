package com.wb.pattern.proxy.customer;

import java.io.*;
import java.net.URLDecoder;

/**
 * 自己定义的ClassLoader
 * @author wangbo
 * @since 2019/11/4 10:49
 */
public class MyClassLoader extends ClassLoader{

    private File classPathFile;

    public MyClassLoader(){
        try {
            String classPath = MyClassLoader.class.getResource("").getPath();
            this.classPathFile = new File(URLDecoder.decode(classPath,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // 重写方法
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = MyClassLoader.class.getPackage().getName() + "." + name;
        if(classPathFile!= null){
            File classFile = new File(classPathFile,name.replace("\\.","/") +".class");
            if(classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while((len = in.read(buff)) != -1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                }catch (Exception e){
                    e.printStackTrace();
                }finally {
                    if(in !=null ){
                        try {
                            in.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if(out!=null){
                        try {
                            out.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return null;
    }
}
