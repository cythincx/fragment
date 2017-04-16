package com.chengyuxing.fragment.tij.concurrent.evenChecker;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/8
 * Time: 下午6:33
 * Description:
 * 偶数检查的程序--《java编程思想》21.3.1
 */
public abstract class IntGenerator {
    private volatile boolean canceled = false;
    public abstract int next();

    public void cancel(){
        this.canceled = true;
    }

    public boolean  isCanceled(){
        return this.canceled;
    }
}
