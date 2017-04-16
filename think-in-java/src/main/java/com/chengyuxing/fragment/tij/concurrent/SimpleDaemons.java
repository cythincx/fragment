package com.chengyuxing.fragment.tij.concurrent;

import java.util.concurrent.TimeUnit;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/4
 * Time: 上午11:26
 * Description:
 */
public class SimpleDaemons implements Runnable {
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
        for(int i = 0; i < 10; i++){
            Thread daemon = new Thread(new SimpleDaemons());
            daemon.setDaemon(true);
            daemon.start();
        }
        println("All daemons started!");
        TimeUnit.MILLISECONDS.sleep(175);
    }
}
