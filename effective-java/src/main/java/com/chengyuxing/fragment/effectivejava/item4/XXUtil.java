package com.chengyuxing.fragment.effectivejava.item4;

/**
 * Created with IntelliJ IDEA.
 * Author: mt-chengyuxing
 * Date: 2017/10/29
 * Time: 下午10:54
 * Desc: 通过私有构造器强化不可实例化的能力。一般针对util工具类
 */
public class XXUtil {
    //避免被实例化
    private XXUtil() {
    }

    public static void doSth(){

    }
}
