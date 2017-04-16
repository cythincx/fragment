package com.chengyuxing.fragment.tij.concurrent.evenChecker;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/8
 * Time: 下午6:46
 * Description:
 */
public class EvenGenerator extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public int next() {
        currentEvenValue+=2;
        //++currentEvenValue;
        return currentEvenValue;
    }

}
