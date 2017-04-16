package com.chengyuxing.fragment.tij.nestedclass;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/1
 * Time: 上午10:57
 * Description:
 */
interface Selector {
    boolean end();

    Object current();

    void next();

    Sequence getSequence();

    void resize();
}
