package com.chengyuxing.fragment.tij.collection;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/13
 * Time: 下午3:32
 * Description:
 */
public class SetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Set<Integer> intset = new HashSet<Integer>();
        for (int i = 0; i < 10000; i++) {
            intset.add(rand.nextInt(30));
        }
        println(intset);
    }
}
