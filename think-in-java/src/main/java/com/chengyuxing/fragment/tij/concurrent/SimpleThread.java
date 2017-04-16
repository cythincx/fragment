package com.chengyuxing.fragment.tij.concurrent;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/4
 * Time: 下午5:06
 * Description:
 * 通过继承Thread实现多线程
 */
public class SimpleThread extends Thread {

    private int countDown = 5;

    private static int taskCount = 0;

    private int id = taskCount++;

    public SimpleThread(String name){
        super(name + taskCount);
        start();
    }

    public String toString(){
        return "#" + getName() + "(" + countDown + ")";
    }

    @Override
    public void run() {
        while(true){
            println(this);
            if(--countDown == 0){
                println(this + " end!");
                return;
            }
        }
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            SimpleThread t = new SimpleThread("ST");
        }
    }
}
