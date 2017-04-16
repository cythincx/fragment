package com.chengyuxing.fragment.tij.nestedclass;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/2
 * Time: 下午3:39
 * Description:
 * 内部类可以放在函数里里面定义
 */
public class Parcel5 {
    public Destination destination(String s){
        class PDestination implements Destination{
            private String label;

            private PDestination(String ss){
                label = ss;
            }

            //@Override
            public String readLabel() {
                return label;
            }
        }

        return new PDestination(s);
    }

    public static void main(String[] args) {
        Parcel5 p = new Parcel5();

        Destination d = p.destination("sdf");
    }
}
