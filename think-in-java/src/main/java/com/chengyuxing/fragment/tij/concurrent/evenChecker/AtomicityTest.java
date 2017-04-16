package com.chengyuxing.fragment.tij.concurrent.evenChecker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/9
 * Time: 下午3:58
 * Description:
 * TIJ 21.3.3
 */
public class AtomicityTest implements Runnable {
    private int i = 0;
    public synchronized int getValue(){
        return i;
    }
    public synchronized void evenIncrement(){
        i++;
        i++;
    }

    //@Override
    public void run() {
        while(true){
            evenIncrement();
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicityTest a = new AtomicityTest();
        exec.execute(a);
        exec.shutdown();

        while(true){
            int val = a.getValue();
            if(val % 100000 == 0)
                println("Thread[0] val=" + val);
            if(val % 2 != 0){
                println("val = " + val);
                System.exit(0);
            }
        }
    }
}
