package com.chengyuxing.fragment.tij.interfaceclass;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/10/31
 * Time: 下午5:59
 * Description:
 */
public abstract class BaseClass {
    public abstract void doit();
    public String name(){
        println("BaseClass name()");
        return "BaseClass";
    }
}
