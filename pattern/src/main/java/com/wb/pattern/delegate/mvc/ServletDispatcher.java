package com.wb.pattern.delegate.mvc;

import com.wb.pattern.delegate.mvc.controller.MenberController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @author wangbo
 * @since 2019/11/6 10:06
 */
public class ServletDispatcher {

    private List<Handler> handlerMapping = new ArrayList<>();

    public ServletDispatcher(){
        Class<?> clazz = MenberController.class;
        try{
            handlerMapping.add(new Handler(clazz.newInstance(),clazz.getMethod("findById",new Class[]{}),"/web/findById.json"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void doService(HttpServletRequest request, HttpServletResponse response){
        this.doDispatch(request,response);
    }

    private void doDispatch(HttpServletRequest request,HttpServletResponse response){
        //1. 获取用户请求url
        String uri = request.getRequestURI();

        //2. Servlet拿到url以后,做判断选择
        //3. 通过拿到的URL去handlerMapping中去找
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if(uri.equals(h.getUrl())){
                handler = h;
                break;
            }
        }

        //4. 将具体的任务分发给Method(通过反射去调用方法)
        Object object = null;
        try {
            object = handler.getMethod().invoke(handler.getController(),request.getParameter("mid"));
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //5. 获取Method执行结果，通过Response返回出去
        try {
            response.getWriter().write(object.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    class Handler{
        private Object controller;
        private Method method;
        private String url;

        public Handler(Object controller, Method method, String url) {
            this.controller = controller;
            this.method = method;
            this.url = url;
        }

        public Object getController() {
            return controller;
        }

        public void setController(Object controller) {
            this.controller = controller;
        }

        public Method getMethod() {
            return method;
        }

        public void setMethod(Method method) {
            this.method = method;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
