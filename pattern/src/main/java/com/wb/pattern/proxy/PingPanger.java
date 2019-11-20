package com.wb.pattern.proxy;

/**
 * 乒乓球运动员
 * @author wangbo
 * @since 2019/11/1 15:38
 */
public class PingPanger implements Athletes {


    @Override
    public void train() {
        System.out.println("乒乓球运动员在训练");
    }

    @Override
    public void match() {
        System.out.println("乒乓球运动员在跟对手比赛");
    }
}
