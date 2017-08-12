package com.chengyuxing.fragment.effectivejava;

import com.chengyuxing.fragment.effectivejava.item1.EffectiveJavaServices;
import com.chengyuxing.fragment.effectivejava.item1.IEffectiveJavaService;
import com.chengyuxing.fragment.effectivejava.item2.BuilderPattern;
import com.chengyuxing.fragment.effectivejava.item2.BuilderPatternProvider;

/**
 * Created with IntelliJ IDEA.
 * Author: mt-chengyuxing
 * Date: 2017/8/12
 * Time: 下午11:00
 * Desc:
 */
public class Main {


    //先注册providers
    static {
        //第二条
        EffectiveJavaServices.registerProvider(BuilderPatternProvider.getInstance());
    }

    public static void main(String[] args) {
        //第二条 遇见多个构造器参数的时候,考虑使用Builder模式.
        IEffectiveJavaService builderPatternService = EffectiveJavaServices.getService(ProviderNameEnum.BUILDER_PATTERN);
        builderPatternService.doService();
    }
}
