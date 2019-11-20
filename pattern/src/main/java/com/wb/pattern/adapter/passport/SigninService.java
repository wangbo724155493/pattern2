package com.wb.pattern.adapter.passport;

import com.wb.pattern.adapter.Member;
import com.wb.pattern.adapter.ResultMsg;

/**
 * @author wangbo
 * @since 2019/11/6 14:17
 */
public class SigninService {

    /**
     * 注册方法
     * @param userName
     * @param password
     * @return
     */
    public ResultMsg register(String userName,String password){
        return new ResultMsg("200","注册成功",new Member());
    }

    /**
     * 登录方法
     * @param userName
     * @param password
     * @return
     */
    public ResultMsg login(String userName,String password){
        return null;
    }
}
