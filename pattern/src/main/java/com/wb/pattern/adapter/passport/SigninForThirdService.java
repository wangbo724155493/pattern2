package com.wb.pattern.adapter.passport;

import com.wb.pattern.adapter.ResultMsg;

/**
 *  稳定的方法不修改直接继承进行扩展
 * @author wangbo
 * @since 2019/11/6 14:26
 */
public class SigninForThirdService extends SigninService{

    public ResultMsg loginForQQ(String openId){
        //1. openId是全局唯一，我们可以把它当作一个用户名(加长);
        //2. 密码默认为QQ_EMPTY
        //3. 注册(在原有的系统里面创建一个用户)
        ResultMsg msg = super.register(openId,null);
        //4. 调用原来的登录方法
        msg = super.login(openId,null);
        return msg;
    }

    public ResultMsg loginForWechat(String openId){
        return null;
    }

    public ResultMsg loginForToken(String token){
        //1. 通过token拿到用户信息，然后再重新登录一次
        return null;
    }

    public ResultMsg loginForTelphone(String telphone,String code){
        return null;
    }
}
