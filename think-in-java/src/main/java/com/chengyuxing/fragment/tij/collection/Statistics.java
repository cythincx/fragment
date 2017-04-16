package com.chengyuxing.fragment.tij.collection;

import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/13
 * Time: 下午3:56
 * Description:
 */
public class Statistics implements Runnable {

    private Random rand = new Random();
    private HashMapTest hm = null;
    private static int cnt = 0;
    private final int id = cnt++;

    public Statistics(HashMapTest hm) {
        this.hm = hm;
    }

    //@Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            int r = rand.nextInt(5);
            //Integer freq = hm.get(r);
            hm.getAndSet(r);
        }
        println("Thread[" + id + "] is over! hashSet:" + hm.print());
    }

    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        HashMapTest hmt = new HashMapTest(map);

        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            exec.execute(new Statistics(hmt));
        }
        exec.shutdown();

    }
}

