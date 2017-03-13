package com.chengyuxing.fragment.util;

import java.util.Collection;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: mt-chengyuxing
 * Date: 2017/3/13
 * Time: 下午6:51
 * Desc:
 */
public class CollectionUtils extends org.springframework.util.CollectionUtils{

    public static boolean isNotEmpty(Collection<?> collection){
        return !isEmpty(collection);
    }

    public static boolean isNotEmpty(Map<?, ?> map) {
        return !isEmpty(map);
    }
}
