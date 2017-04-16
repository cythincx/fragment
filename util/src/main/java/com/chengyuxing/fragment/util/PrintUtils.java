package com.chengyuxing.fragment.util;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2017/4/16
 * Time: 下午3:54
 * Description:
 */
public class PrintUtils {
    public static void println(Object... str){
        for (Object s1 : str) {
            System.out.println(s1);
        }
    }

    public static void print(Object ... str){
        for (Object s : str) {
            System.out.print(s);
        }
    }
}
