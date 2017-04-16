package com.chengyuxing.fragment.tij.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/3
 * Time: 下午6:19
 * Description:
 */
public class SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        for(int i = 0; i < 5; i++ )
            exec.execute(new LiftOff());
        exec.shutdown();
    }
}
