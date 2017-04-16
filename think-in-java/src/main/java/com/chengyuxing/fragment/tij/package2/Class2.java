package com.chengyuxing.fragment.tij.package2;

import com.chengyuxing.fragment.tij.package1.Class1;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/10/28
 * Time: 下午2:44
 * Description:
 */
public class Class2 extends Class1 {
    public void foo(){
        System.out.println(class1key);
    }

    public void doClass1Print(){
        Class1 c1 = new Class1();
        //c1.print();
        super.print();
    }

    public static void main(String[] args) {
        Class2 class2 = new Class2();
        class2.foo();
        class2.print();

        Class1 c1 = new Class1();
        //c1.print();
        class2.doClass1Print();
    }
}
