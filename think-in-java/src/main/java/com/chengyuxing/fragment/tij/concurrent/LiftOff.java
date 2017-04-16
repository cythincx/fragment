package com.chengyuxing.fragment.tij.concurrent;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/2
 * Time: 下午6:25
 * Description:
 * 10秒倒计时
 */
public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;
    public LiftOff(){}

    public LiftOff(int countDown){
        this.countDown = countDown;
    }
    public String status(){
        return "#" + id + "(" +
                (countDown > 0 ? countDown : "LiftOff!") + ")";
    }

    //@Override
    public void run() {
        while(countDown-- > 0){
            println(status());
            Thread.yield();
        }
    }
}
