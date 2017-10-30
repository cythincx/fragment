package com.chengyuxing.fragment.effectivejava.item3;

/**
 * Created with IntelliJ IDEA.
 * Author: mt-chengyuxing
 * Date: 2017/8/15
 * Time: 上午12:46
 * Desc: 用私有构造器或者枚举类型强化Singleton属性
 * 利用单元素的枚举类型来实现单例。
 */
public enum SunEnum {
    INSTANCE;

    public String whoAmI(){
        return "我是唯一一个在后羿手下逃生的太阳";
    }
}
