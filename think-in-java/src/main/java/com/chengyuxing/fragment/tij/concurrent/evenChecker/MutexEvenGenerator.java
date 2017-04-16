package com.chengyuxing.fragment.tij.concurrent.evenChecker;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/9
 * Time: 下午3:30
 * Description:
 */
public class MutexEvenGenerator extends IntGenerator {
    private Lock lock = new ReentrantLock();
    private int currentEvenValue = 0;

    @Override
    public int next() {
        lock.lock();
        try{
            ++ currentEvenValue;
            Thread.yield();
            ++ currentEvenValue;
            return currentEvenValue;
        }finally {
            lock.unlock();
        }

    }
}
