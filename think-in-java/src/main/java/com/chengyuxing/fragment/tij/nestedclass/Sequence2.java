package com.chengyuxing.fragment.tij.nestedclass;

import static com.chengyuxing.fragment.util.PrintUtils.print;
import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/1
 * Time: 上午11:16
 * Description:内部类实现
 */
public class Sequence2 extends Sequence{
    private Object[] items;
    private int current = 0;
    public Sequence2(int i){
        items = new Object[i];
    }
    public void add(Object o){
        if(current < items.length){
            items[current++] = o;
        }
    }

    private class Sequence2Selector implements Selector{

        private int i = 0;

        //@Override
        public boolean end() {
            return i >= items.length;
        }

        //@Override
        public Object current() {
            return end() ? null : items[i];
        }

        //@Override
        public void next() {
            if(i < items.length){
                i ++;
            }
        }

        public Sequence2 getSequence(){
            return Sequence2.this;
        }

        public void resize(){
            i = 0;
        }
    }

    public Selector getSelector(){
        return new Sequence2Selector();
    }

    public static void main(String[] args) {
        Sequence2 s2 = new Sequence2(20);
        for(int i = 0; i < 19; i++){
            s2.add(Integer.toString(i));
        }
        Selector selector = s2.getSelector();
        while(!selector.end()){
            print(selector.current() + " ");
            selector.next();
        }
        selector.getSequence().add(100);
        selector.resize();
        println("");
        while(!selector.end()){
            print(selector.current() + " ");
            selector.next();
        }
        println("");
        if(s2.equals(selector.getSequence())){
            println("s2.equals(selector.getSequence())");
        }else{
            println("!s2.equals(selector.getSequence())");
        }
    }
}
