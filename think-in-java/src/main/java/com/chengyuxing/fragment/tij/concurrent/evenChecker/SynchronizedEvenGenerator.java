package com.chengyuxing.fragment.tij.concurrent.evenChecker;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/9
 * Time: 下午2:45
 * Description:
 */
public class SynchronizedEvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        currentEvenValue++;
        Thread.yield();
        currentEvenValue++;
        return currentEvenValue;
    }
}
