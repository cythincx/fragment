package com.chengyuxing.fragment.effectivejava.item2;

import com.chengyuxing.fragment.effectivejava.ProviderNameEnum;
import com.chengyuxing.fragment.effectivejava.item1.IEffectiveJavaProvider;
import com.chengyuxing.fragment.effectivejava.item1.IEffectiveJavaService;
import com.chengyuxing.fragment.util.PrintUtils;

/**
 * Created with IntelliJ IDEA.
 * Author: mt-chengyuxing
 * Date: 2017/8/12
 * Time: 下午10:30
 * Desc:
 */
public class BuilderPatternProvider implements IEffectiveJavaProvider {

    ProviderNameEnum name = ProviderNameEnum.BUILDER_PATTERN;

    public ProviderNameEnum getName() {
        return name;
    }

    public void setName(ProviderNameEnum name) {
        this.name = name;
    }

    private static IEffectiveJavaProvider provider;

    private BuilderPatternProvider(){}

    public static IEffectiveJavaProvider getInstance(){
        if(null==provider){
            synchronized (BuilderPatternProvider.class){
                if(null==provider){
                    provider = new BuilderPatternProvider();
                }
            }
        }
        return provider;
    }

    public IEffectiveJavaService provide() {
        return BuilderPatternService.getInstance();
    }

    public static class BuilderPatternService implements IEffectiveJavaService{

        private BuilderPatternService(){}

        private static IEffectiveJavaService service;

        public static IEffectiveJavaService getInstance(){
            if(null==service){
                synchronized (BuilderPatternService.class){
                    if(null==service){
                        service = new BuilderPatternService();
                    }
                }
            }
            return service;
        }

        public static IEffectiveJavaService newInstance(){
            return new BuilderPatternService();
        }

        public void doService() {
            BuilderPattern.Builder cythincxBuilder = new BuilderPattern.Builder().name("cythincx").age(24).gender(1);

            BuilderPattern cyx1 = cythincxBuilder.country("China").build();
            BuilderPattern cyx2 = cythincxBuilder.country("USA").city("NYC").build();

            PrintUtils.println(cyx1,cyx2);

        }
    }
}
