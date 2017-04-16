package com.chengyuxing.fragment.tij.concurrent.evenChecker;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/8
 * Time: 下午6:37
 * Description:
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;

    private final int id;

    public EvenChecker(IntGenerator g, int ident){
        this.generator = g;
        this.id = ident;
    }

    //@Override
    public void run() {
        while(!generator.isCanceled()){
            int val = generator.next();
            if(val % 100000 == 0)
                println("Thread[" + id + "] val=" + val);
            if(val % 2 != 0){
                println(val + " not even!Thread[" + id + "]");
                generator.cancel();
            }
            if(val >= 1000000000){
                println("Thread[" + id + "] is Over! val = " + val);
                generator.cancel();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        //IntGenerator g = new EvenGenerator();
        //SynchronizedEvenGenerator g = new SynchronizedEvenGenerator();
        MutexEvenGenerator g = new MutexEvenGenerator();
        for (int i = 0; i < 10; i++) {
            exec.execute(new EvenChecker(g,i));
        }
        exec.shutdown();
    }
}
