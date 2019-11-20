package com.wb.pattern.proxy.staticed;

import com.wb.pattern.proxy.Athletes;

/**
 * 运动员代理类
 * @author wangbo
 * @since 2019/11/1 15:39
 */
public class AthletesProxy implements Athletes {

    private Athletes athletes;

    public AthletesProxy(Athletes athletes){
        this.athletes = athletes;
    }

    @Override
    public void train() {
        System.out.println("帮助运动员热身，准备营养餐");
        athletes.train();
        System.out.println("帮助运动员进行放松");
    }

    @Override
    public void match() {
        System.out.println("联系比赛");
        athletes.match();
        System.out.println("联系机票返程");
    }
}
