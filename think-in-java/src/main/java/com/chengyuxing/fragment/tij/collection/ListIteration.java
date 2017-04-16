package com.chengyuxing.fragment.tij.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/12
 * Time: 下午10:54
 * Description:
 */
public class ListIteration {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            lst.add(Integer.toString(i));
        }

        ListIterator<String> it = lst.listIterator();
        while(it.hasNext())
            println(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex());

        while(it.hasPrevious())
            println(it.previous());

        it = lst.listIterator(3);
        while(it.hasNext()){
            it.next();
            it.set(it.previousIndex() + " 呵呵");
        }

        println(lst);
    }
}
