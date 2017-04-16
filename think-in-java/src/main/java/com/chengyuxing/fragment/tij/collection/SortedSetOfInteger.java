package com.chengyuxing.fragment.tij.collection;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

import static jdk.nashorn.internal.objects.Global.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/13
 * Time: 下午3:46
 * Description:
 */
public class SortedSetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> intset = new TreeSet<Integer>();
        for (int i = 0; i < 10000; i++) {
            intset.add(rand.nextInt(30));
        }
        println(intset);
    }
}
