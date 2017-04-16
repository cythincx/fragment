package com.chengyuxing.fragment.tij.nestedclass;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/10/31
 * Time: 下午7:14
 * Description:
 */
public class Outer {
    public Inner getInner(){
        return new Inner();
    }

    public Inner getInner(int i){
        return new Inner(i);
    }

    class Inner{

        private int i1;
        public int getI1() {
            return i1;
        }
        public void setI1(int i1) {
            this.i1 = i1;
        }
        Inner(){
            i1 = 0;
        }
        Inner(int i){
            i1 = i;
        }
    }

    public static void main(String[] args) {
        Outer  o1 = new Outer();
        Inner i = o1.getInner();
        println(i.getI1());
    }
}
