package com.chengyuxing.fragment.tij.concurrent;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/3
 * Time: 上午12:25
 * Description:
 */
public class BasicThreads {
    public static void main(String[] args) {
        Thread t = new Thread(new LiftOff());
        t.start();
        println("Waiting for LiftOff");
    }
}
