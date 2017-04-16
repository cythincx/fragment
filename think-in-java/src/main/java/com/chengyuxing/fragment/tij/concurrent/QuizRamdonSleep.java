package com.chengyuxing.fragment.tij.concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/4
 * Time: 上午12:17
 * Description:
 */
public class QuizRamdonSleep implements Runnable {
    protected int sleepTime = 0;

    private static Random rand = new Random(47);

    private static int taskCount = 0;

    protected final int id = taskCount ++ ;

    public QuizRamdonSleep(){
        sleepTime = rand.nextInt(20) + 1;
    }

    //@Override
    public void run() {
        println("task " + id + " sleep start..... ");
        try{
            TimeUnit.SECONDS.sleep(sleepTime);
        }catch(InterruptedException e){
            println("InterruptedException");
        }
        println("wow, task " + id + " slept " + sleepTime + " seconds");
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            exec.execute(new QuizRamdonSleep());
        }
        exec.shutdown();
    }
}
