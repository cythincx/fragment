package com.chengyuxing.fragment.tij.interfaceclass;
import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/10/31
 * Time: 下午6:02
 * Description:
 */
public class Class1 extends BaseClass implements Interface1, Interface2 {
    @Override
    public void doit() {
        println("doit Class1");
    }

    //@Override
    public void printInterface1() {
        println("printInterface1");
    }

    //@Override
    public void printInterface2(int i) {
        println("printInterface2:" + i);
    }
}
