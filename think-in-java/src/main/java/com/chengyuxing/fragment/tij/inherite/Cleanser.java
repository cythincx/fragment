package com.chengyuxing.fragment.tij.inherite;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/10/30
 * Time: 下午2:16
 * Description:
 */
class Cleanser {
    private String s = "Cleanser";

    public Cleanser(){
        println("Cleanser Constructor...");
    }

    public Cleanser(String s){
        this.s = s;
        println("Cleanser(String s) Constructor...");
    }

    public void append(String a){
        s += a;
    }
    public void dilute(){
        append("dilute()");
    }
    public void apply(){
        append("apply()");
    }
    public void scrub(){
        append("scrub()");
    }
    public String toString(){
        return s;
    }
    public static void main(String[] args){
        Cleanser x = new Cleanser();
        x.dilute();
        x.apply();
        x.scrub();
        println(x);
    }

    public void setS(String s){
        this.s = s;
    }

    public String getS(){
        return this.s;
    }
}
