package com.chengyuxing.fragment.tij.concurrent;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/3
 * Time: 上午12:27
 * Description:
 */
public class MoreBasicThreads {
    public static void main(String[] args) {
        for(int i = 0; i < 5; i++ ){
            new Thread(new LiftOff()).start();
        }
        //println("Waiting for LiftOff");
    }
}
