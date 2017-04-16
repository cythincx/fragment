package com.chengyuxing.fragment.tij.abstractclass;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/10/31
 * Time: 下午5:50
 * Description:
 */
public abstract class Instrument {
    private int i;
    public abstract void play();
    public String what(){
        return "Instrument";
    }
    public abstract  void adjust();
}
