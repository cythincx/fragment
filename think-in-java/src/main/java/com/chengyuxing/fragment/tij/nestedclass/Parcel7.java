package com.chengyuxing.fragment.tij.nestedclass;

import static com.chengyuxing.fragment.util.PrintUtils.print;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/2
 * Time: 下午4:07
 * Description:
 * 匿名内部类
 */
public class Parcel7 {
    public Contents contents(){
        return new Contents(){//匿名的内部类隐式的实现(继承)Contents接口
            private int i = 11;

            //@Override
            public int value() {
                return i;
            }
        };
    }

    public static void main(String[] args) {
        Parcel7 p = new Parcel7();
        Contents c = p.contents();
        print(c.value());
    }
}
