package com.chengyuxing.fragment.effectivejava;

/**
 * Created with IntelliJ IDEA.
 * Author: mt-chengyuxing
 * Date: 2017/8/12
 * Time: 下午11:02
 * Desc:
 */
public enum ProviderNameEnum {

    //构造器模式
    BUILDER_PATTERN("Builder_Pattern(In item 2)");

    private String providerName;

    private ProviderNameEnum(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderName(){
        return this.providerName;
    }
}
