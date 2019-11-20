package com.wb.pattern.proxy.customer;
import com.wb.pattern.proxy.Athletes;
import java.lang.reflect.Method;
public class $Proxy0 implements Athletes{
MyInvocationHandler h;
public $Proxy0(MyInvocationHandler h){
this.h = h;
}
public void match(){
try{
Method m = com.wb.pattern.proxy.Athletes.class.getMethod("match",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){
e.printStackTrace();}
}
public void train(){
try{
Method m = com.wb.pattern.proxy.Athletes.class.getMethod("train",new Class[]{});
this.h.invoke(this,m,null);
}catch(Throwable e){
e.printStackTrace();}
}
}
