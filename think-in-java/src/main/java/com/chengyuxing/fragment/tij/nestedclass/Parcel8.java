package com.chengyuxing.fragment.tij.nestedclass;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/2
 * Time: 下午4:16
 * Description:
 */
public class Parcel8 {
    public Wrapping getWrapping(int i){
        return new Wrapping(i){
            {
                super.i = ++i;
            }
            public int value(){
                return super.value() * 47;
            }
        };
    }

    public static void main(String[] args) {
        Parcel8 p = new Parcel8();
        Wrapping w = p.getWrapping(10);
        println(w.value());
    }
}

class Wrapping{
    protected int i;
    public Wrapping(int ii){
        this.i = ii;
    }
    public int value(){
        return i;
    }
}
