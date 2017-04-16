package com.chengyuxing.fragment.tij.interfaceclass;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/10/31
 * Time: 下午6:02
 * Description:多重继承
 */
public class Main {
    public static void main(String[] args) {
        BaseClass c1 = new Class1();
        c1.doit();
        c1.name();

        Interface1 i1 = new Class1();
        i1.printInterface1();

        Interface2 i2 = new Class1();
        i2.printInterface2(5);

        Class1 c2 = new Class1();
        c2.doit();
        c2.name();
        c2.printInterface1();
        c2.printInterface2(6);
    }
}
