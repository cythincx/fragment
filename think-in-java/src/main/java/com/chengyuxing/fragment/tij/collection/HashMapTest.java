package com.chengyuxing.fragment.tij.collection;

import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/13
 * Time: 下午4:10
 * Description:
 */
public class HashMapTest {
    private volatile Map<Integer, Integer> m;
    private volatile int setCnt = 0;
    private volatile int getCnt = 0;

    public HashMapTest(Map<Integer, Integer> m){
        this.m = m;
    }

    public synchronized  void set(Integer k, Integer v){
        m.put(k, v == null ? 1 : v + 1);
        setCnt++;
    }

    public synchronized Integer get(Integer k){
        getCnt++;
        return m.get(k);
    }

    public synchronized  void getAndSet(Integer k){
        Integer freq = m.get(k);
        m.put(k, freq == null ? 1 : freq + 1);
        setCnt++;
        getCnt++;
    }

    public synchronized String print(){
        return m.toString() + " setCnt = " + setCnt + " getCnt = " + getCnt;
    }

}
