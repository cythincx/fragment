package com.chengyuxing.fragment.tij.nestedclass;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/2
 * Time: 下午3:42
 * Description:
 * 内部类定义在作用域里
 */
public class Parcel6 {
    public void internalTracking(boolean b){
        if(b){
            class TrackingSlip{
                private String id;
                TrackingSlip(String s){
                    id = s;
                }
                String getSlip(){
                    println(id);
                    return id;
                }
            }
            TrackingSlip ts = new TrackingSlip("TrackingSlip");
            ts.getSlip();
        }
    }

    public void track(){
        internalTracking(true);
    }

    public static void main(String[] args) {
        Parcel6 p = new Parcel6();
        p.track();
    }
}
