package com.chengyuxing.fragment.tij.concurrent;

import java.util.concurrent.TimeUnit;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/4
 * Time: 下午3:16
 * Description:
 */
public class ADaemon implements Runnable {
    //@Override
    public void run() {
        try{
            println("adaemon start");
            TimeUnit.SECONDS.sleep(1);
            println("sleep over");
        }catch(InterruptedException e){
            println("InterruptedException");
        }finally {
            println("this should always run?");
        }
    }

    public static void main(String[] args) throws Exception {
        Thread t = new Thread(new ADaemon());
        t.setDaemon(true);
        t.start();

        TimeUnit.MILLISECONDS.sleep(998);
    }
}
