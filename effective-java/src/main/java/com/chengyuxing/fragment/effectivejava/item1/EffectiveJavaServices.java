package com.chengyuxing.fragment.effectivejava.item1;

import com.chengyuxing.fragment.effectivejava.ProviderNameEnum;
import com.google.common.collect.Maps;

import java.security.Provider;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Author: mt-chengyuxing
 * Date: 2017/8/12
 * Time: 下午8:34
 * Desc: 第一条: 考虑用静态工厂方法代替构造器
 */
public class EffectiveJavaServices {

    private static Map<ProviderNameEnum, IEffectiveJavaProvider> providers = Maps.newConcurrentMap();

    private EffectiveJavaServices(){}

    public static void registerProvider(IEffectiveJavaProvider p){
        if(null==p||p.getName()==null)
            return;
        providers.put(p.getName(),p);
    }


    public static IEffectiveJavaService getService(ProviderNameEnum serviceName){
        IEffectiveJavaProvider provider = providers.get(serviceName);
        if(null==provider){
            throw new IllegalArgumentException("没有对应的provider");
        }
        return provider.provide();
    }


}
