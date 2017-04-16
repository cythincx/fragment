package com.chengyuxing.fragment.tij.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/4
 * Time: 上午12:40
 * Description:
 */
public class SimplePriorities implements Runnable {

    private int countDown = 5;

    private volatile double d;

    private int priority;

    public SimplePriorities(int priority){
        this.priority = priority;
    }

    public String toString(){
        return Thread.currentThread() + ": " + countDown;
    }

    //@Override
    public void run() {
        Thread.currentThread().setPriority(priority);
        while(true){
            for(int i = 0; i < 10000000; i++){
                d += (Math.PI + Math.E) / (double)i;
                if(i %  1000 == 0){
                    Thread.yield();
                }
            }
            println(this);
            if(--countDown == 0){
                return;
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
        }
        exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
        exec.shutdown();
    }
}
