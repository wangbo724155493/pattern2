package com.wb.pattern.proxy.customer;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.URLDecoder;

/**
 * 自己定义的Proxy
 * @author wangbo
 * @since 2019/11/4 10:48
 */
public class MyProxy {

    // 换行符
    private static final String LN = "\r\n";
    private static Long serial = 0l;

    public static Object newProxyInstance(MyClassLoader classLoader,Class<?>[] interfaces,MyInvocationHandler h){
        try {
            //1. 动态生成源代码.java文件
            String src = generateSrc(interfaces);

            //2. 把java文件输出到磁盘
            String ClassName = "$Proxy" + serial++;
            String filePath = MyProxy.class.getResource("").getPath();
            File file = new File(URLDecoder.decode(filePath,"UTF-8") + ClassName + ".java");
            FileWriter fw = new FileWriter(file);
            fw.write(src);
            fw.flush();
            fw.close();
            //3. 把生成的java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable<? extends JavaFileObject> iterable = manager.getJavaFileObjects(file);

            JavaCompiler.CompilationTask task = compiler.getTask(null, manager, null, null, null, iterable);
            task.call();
            manager.close();

            //4. 把编译生成的class文件加载到JVM中
            Class proxyClass = classLoader.findClass(ClassName);
            Constructor constructor = proxyClass.getConstructor(MyInvocationHandler.class);

            //5. 返回字节码重组后新的代理对象
            return constructor.newInstance(h);
        }catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    /**
     * 生成.java文件
     * @param interfaces
     * @return
     */
    private static String generateSrc(Class<?>[] interfaces) {

        StringBuffer sb = new StringBuffer();
        sb.append("package com.wb.pattern.proxy.customer;" + LN);
        for (Class<?> anInterface : interfaces) {
            sb.append("import " + anInterface.getName() + ";" + LN);
        }
        sb.append("import java.lang.reflect.Method;" + LN);

        sb.append("public class $Proxy0 implements " + interfaces[0].getSimpleName() + "{" + LN);

            sb.append("MyInvocationHandler h;" + LN);

            sb.append("public $Proxy0(MyInvocationHandler h){" + LN);
                sb.append("this.h = h;" + LN);
            sb.append("}" + LN);

            for(Method m : interfaces[0].getMethods()){
                sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + LN );
                    sb.append("try{" + LN);
                        // 通过反射去调用方法
                        sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\""+ m.getName() + "\",new Class[]{});" + LN);
                        sb.append("this.h.invoke(this,m,null);" + LN);
                    sb.append("}catch(Throwable e){" + LN);
                        sb.append("e.printStackTrace();");
                    sb.append("}"+LN);
                sb.append("}" + LN);
            }


        sb.append("}"+LN);

        return sb.toString();
    }

}
