package com.chengyuxing.fragment.tij.concurrent;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/3
 * Time: 下午10:32
 * Description:
 */
public class TaskWithResult implements Callable<String> {
    private int id;
    public TaskWithResult(int i){
        this.id = i;
    }

    //@Override
    public String call() throws Exception {
        return "result of TaskWithResult " + id;
    }
}
