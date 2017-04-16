package com.chengyuxing.fragment.tij.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/2
 * Time: 下午6:33
 * Description:
 */
public class Main {
    public static void main(String[] args) {
        //
        /*
        LiftOff lo = new LiftOff(100);
        lo.run();
        */

        //21.2.4 Callable
        /*
        ExecutorService exec = Executors.newCachedThreadPool();
        ArrayList<Future<String>> result = new ArrayList<Future<String>>();

        for(int i = 0; i < 10; i++){
            result.add(exec.submit(new TaskWithResult(i)));
        }
        for (Future<String> fs : result) {
            try {
                println(fs.get());
            } catch (InterruptedException e) {
                println(e);
            }catch (ExecutionException e){
                println(e);
            }finally {
                exec.shutdown();
            }
        }
        */

        //QuizRandomSleep
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 10; i++){
            exec.execute(new QuizRamdonSleep());
        }
        exec.shutdown();
    }
}
