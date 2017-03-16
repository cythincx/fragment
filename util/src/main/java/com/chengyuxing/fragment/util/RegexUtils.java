package com.chengyuxing.fragment.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: mt-chengyuxing
 * Date: 2017/3/13
 * Time: 下午6:50
 * Desc:
 */
public class RegexUtils {

    //private static final String NUM = "-?[0-9]+.?[0-9]+";
    /**
     * 判断字符串是否由 汉字,英文大小写,数字,括号(全角和半角),下划线组成
     * @param str
     * @return
     */
    public static boolean checkStringValid(String str){
        Pattern pattern = Pattern.compile("[\u4e00-\u9fa5a-zA-Z0-9\\(\\)\\(\\)_]*");
        return checkString(str, pattern);
    }

    /**
     * 字符串是否匹配正则表达式
     * @param str
     * @param regex
     * @return
     */
    public static boolean checkString(String str, String regex){
        Pattern pattern = Pattern.compile(regex);
        return checkString(str,pattern);
    }

    /**
     * 是否匹配正则表达式
     * @param str
     * @param pattern
     * @return
     */
    public static boolean checkString(String str, Pattern pattern){
        Matcher m = pattern.matcher(str);
        return m.matches();
    }

    /**
     * 验证整数
     *
     * @param integer
     * @return
     */
    public static boolean checkInteger(String integer) {
        if (integer == null) {
            return false;
        }
        String regex = "^-?\\d+$";
        return Pattern.matches(regex, integer);
    }

    /**
     * 验证正整数，不包含0
     *
     * @param integer
     * @return
     */
    public static boolean checkPositiveInteger(String integer) {
        if (integer == null) {
            return false;
        }
        String regex = "^[1-9]\\d*$";
        return Pattern.matches(regex, integer);
    }

//    public static boolean isNumeric(String str){
//        return checkString(str, NUM);
//    }
}
