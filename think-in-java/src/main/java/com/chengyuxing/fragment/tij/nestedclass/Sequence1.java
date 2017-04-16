package com.chengyuxing.fragment.tij.nestedclass;

import static com.chengyuxing.fragment.util.PrintUtils.print;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/1
 * Time: 上午10:57
 * Description:
 * 一个序列的普通实现方式
 */
public class Sequence1 extends Sequence{
    private Object[] items;
    private int current = 0;
    public Sequence1(int i){
        items = new Object[i];
    }
    public boolean end(){
        return current >= items.length;
    }
    public Object current(){
        return end()?null:items[current];
    }
    public void next(){
        if(current < items.length){
            current ++;
        }
    }

    public static void main(String[] args) {
        Sequence1 s1 = new Sequence1(10);
        for(int i = 0; i < 10; i++ ){
            s1.items[i] = Integer.toString(i);
        }
        while(!s1.end()){
            print(s1.current() + " ");
            s1.next();
        }

    }
}
