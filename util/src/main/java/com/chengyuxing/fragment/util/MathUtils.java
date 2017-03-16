package com.chengyuxing.fragment.util;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * Author: mt-chengyuxing
 * Date: 2017/3/16
 * Time: 下午5:49
 * Desc:
 */
public class MathUtils {

    private static List<String> operators = ImmutableList.<String>builder()
            .add("+")
            .add("-")
            .add("*")
            .add("/")
            .add("(")
            .add(")")
            .build();

    private static Map<String, Integer> priorityMap = ImmutableMap.<String, Integer>builder()
            .put("*", 1)
            .put("/", 1)
            .put("+", 2)
            .put("-", 2)
            .put(")", 3)
            .put("(", 3)
            .build();

    /**
     * 将普通的中缀表达式转化成后缀表达式/逆波兰表达式
     *
     * @param expression a + b * c - (d - e) * f
     *                   12 + 7 * (-5) - (9.4 - 2) * 0.1
     * @return
     */
    public static List<String> convert2RPN(String expression) {

        char[] chararr = expression.toCharArray();
        String [] strarr = new String[chararr.length];
        for(int i = 0;i<chararr.length;i++){
            strarr[i] =Character.toString(chararr[i]);
        }
        List<String> result = new ArrayList<String>();
        String operand = "";
        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < chararr.length; i++) {
            //如果是操作符
            String str = strarr[i];
            if (operators.contains(str)) {
                //输出
                result.add(operand);
                operand = "";
                if (stack.isEmpty()) {
                    stack.push(str);
                } else {
                    if (str.equals("(")) {
                        stack.push(str);
                    } else if (str.equals(")")) {
                        String top = stack.peek();
                        while (!top.equals("(")) {
                            result.add(top);
                            stack.pop();
                            top = stack.peek();
                        }
                        stack.pop();
                    }//+,-,*,/
                    else {
                        String top = stack.peek();
                        while (priorityMap.get(top) <= priorityMap.get(str)) {
                            result.add(top);
                            stack.pop();
                            if (stack.isEmpty()) {
                                break;
                            }
                            top = stack.peek();
                        }
                        stack.push(str);
                    }
                }
            } else if (!str.equals(" ")) {
                operand += str;
                if (i == chararr.length - 1) {
                    result.add(operand);
                }
            }
        }
        while (!stack.isEmpty()) {
            String temp = stack.pop();
            result.add(temp);
        }
        return result;
    }

//    public static double calculate(){
//
//    }

    public static void main(String[] args) {
        String express = "a+b*c-(d-e)*f";
        //String express = "A+B*(C-D)/E+F/H";
        String express2 = "12 + 7 * (-5) - (9.4 - 2) * 0.1";
        List<String> result = convert2RPN(express);
        List<String> result2 = convert2RPN(express2);
        System.out.println(result);
        System.out.println(result2);
    }
}
