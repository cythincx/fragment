package com.chengyuxing.fragment.tij.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/4
 * Time: 上午11:38
 * Description:
 */
public class DaemonFromFactory implements Runnable {
    //@Override
    public void run() {
        try{
            while(true){
                TimeUnit.MILLISECONDS.sleep(100);
                println(Thread.currentThread() + " " + this);
            }
        }catch(InterruptedException e){
            println(e);
        }
    }

    public static void main(String[] args) throws Exception {
        ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for(int i = 0; i < 10; i++){
            exec.execute(new DaemonFromFactory());
        }
        println("all daemons started!");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
