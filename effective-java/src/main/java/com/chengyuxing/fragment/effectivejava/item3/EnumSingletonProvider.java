package com.chengyuxing.fragment.effectivejava.item3;

import com.chengyuxing.fragment.effectivejava.ProviderNameEnum;
import com.chengyuxing.fragment.effectivejava.item1.IEffectiveJavaProvider;
import com.chengyuxing.fragment.effectivejava.item1.IEffectiveJavaService;

/**
 * Created with IntelliJ IDEA.
 * Author: mt-chengyuxing
 * Date: 2017/8/15
 * Time: 上午12:50
 * Desc:
 */
public class EnumSingletonProvider implements IEffectiveJavaProvider{

    ProviderNameEnum name = ProviderNameEnum.ENUM_SINGLETON;


    public IEffectiveJavaService provide() {
        return null;
    }

    public ProviderNameEnum getName() {
        return name;
    }

    public static class EnumSingletonService implements IEffectiveJavaService{
        public void doService() {

        }
    }
}
