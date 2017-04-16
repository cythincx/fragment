package com.chengyuxing.fragment.tij.concurrent;

import java.util.concurrent.TimeUnit;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/4
 * Time: 下午5:19
 * Description:
 */

class Sleeper extends Thread {
    private int duration = 0;;
    public Sleeper(String name, int duration){
        super(name);
        this.duration = duration;
        this.start();
    }

    @Override
    public void run() {
        try{
            TimeUnit.MILLISECONDS.sleep(duration);
        }catch(InterruptedException e){
            println(getName() + " InterruptedException");
        }
        println(getName() + " has awakened");
    }
}

class Joiner extends Thread {

    private Sleeper sleeper = null;

    public Joiner(String name, Sleeper e){
        super(name);
        this.sleeper = e;
        this.start();

    }

    public void run(){
        try{
            sleeper.join();
        }catch(InterruptedException e){
            println("Joiner InterruptedException");
        }
        println(getName() + " join completed");
    }

}

public class Joining {
    public static void main(String[] args) {
        Sleeper sleepy = new Sleeper("Sleepy", 1500);
        Sleeper grumpy = new Sleeper("Grumpy", 1500);
        Joiner dopey = new Joiner("Dopey", sleepy);
        Joiner doc = new Joiner("Doc", grumpy);

        grumpy.interrupt();
    }
}
