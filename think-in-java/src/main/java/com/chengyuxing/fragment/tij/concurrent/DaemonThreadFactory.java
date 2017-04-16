package com.chengyuxing.fragment.tij.concurrent;

import java.util.concurrent.ThreadFactory;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/4
 * Time: 上午11:35
 * Description:
 */
public class DaemonThreadFactory implements ThreadFactory {
    //@Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setDaemon(true);
        return t;
    }
}
