package com.chengyuxing.fragment.tij.Polymorphism;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/10/31
 * Time: 上午11:31
 * Description:
 */
public class Main {
    public static void doRide(Cycle c){
        c.ride();
    }

    public static void main(String[] args) {
        Cycle c = new Bicycle();
        Unicycle u1 = new Unicycle();
        Cycle u2 = new Unicycle();
        Bicycle b1 = new Bicycle();
        Cycle b2 = new Bicycle();
        Tricycle t1 = new Tricycle();
        Cycle t2 = new Tricycle();

        doRide(c);
        doRide(u1);
        doRide(u2);
        doRide(b1);
        doRide(b2);
        doRide(t1);
        doRide(t2);
    }
}
