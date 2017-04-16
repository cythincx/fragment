package com.chengyuxing.fragment.tij.collection;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/12
 * Time: 下午10:26
 * Description:
 */
public class ListTest {

    private static int cnt = 10000;

    public static void insert(List<String> lst){
        if(null == lst || lst.size() < 0)
            return;
        long start, end;
        start = System.currentTimeMillis();
        for (int i = 0; i < cnt; i++) {
            int insertPoint = lst.size() / 2;
            lst.add(insertPoint, Integer.toString(i));
        }
        end = System.currentTimeMillis();
        println("插入共用时:" + (end - start) + "ms");
    }

    public static void main(String[] args) {
        List<String> lst1 = new ArrayList<String>();
        List<String> lst2 = new LinkedList<String>();

        println("ArrayList insert test...");
        insert(lst1);

        println("LinkedList insert test...");
        insert(lst2);

    }
}
