package com.chengyuxing.fragment.tij.inherite;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/10/30
 * Time: 下午2:21
 * Description:
 */
public class Detergent extends Cleanser {
    @Override
    public void scrub(){
        append("Detergent.scrub()");
        super.scrub();
    }
    public void foam(){
        append("foam()");
    }

    public Detergent(){
        println("Detergent Constructor...");
    }

    public Detergent(String s){
        super(s);
        println("Detergent(String s) Constructor...");
    }

    public static void main(String[] args) {
        Detergent x = new Detergent();
        x.dilute();
        x.apply();
        x.scrub();
        x.foam();
        println(x);
        println("test base class");
        Cleanser.main(args);
        Detergent y  = new Detergent("y");
        println("-------------------");
        println(x.getS());
    }
}
