package com.chengyuxing.fragment.util;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.springframework.util.StringUtils;

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

    private static final List<String> testexpr = ImmutableList.<String>builder()
            .add("-3*5-(-2-6+3*(-1))")
            .add("-2/(-3*(-1))*(-2/(6+1))")
            .add("(5-(3+2)*(-2)*4)/3")
            .add("(5+2/3)/(2*0)")
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
        String[] strarr = new String[chararr.length];
        for (int i = 0; i < chararr.length; i++) {
            strarr[i] = Character.toString(chararr[i]);
        }
        List<String> result = new ArrayList<String>();
        String operand = "";
        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < chararr.length; i++) {
            //如果是操作符
            String str = strarr[i];
            if (operators.contains(str)) {
                //输出
                if (i == 0 && str.equals("-")) {
                    operand += str;
                    continue;
                }
                if (!StringUtils.isEmpty(operand)) {
                    result.add(operand);
                }
                operand = "";
                if (stack.isEmpty()) {
                    stack.push(str);
                } else {
                    if (str.equals("(")) {
                        stack.push(str);
                        if (strarr[i + 1].equals("-")) {
                            operand += strarr[++i];
                            continue;
                        }
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

    public static double mainCalculate(List<String> list) {
        Stack<Double> stack = new Stack<Double>();

        for (String s : list) {
            boolean isNum = false;
            double temp = 0.0;
            try {
                temp = Double.parseDouble(s);
                isNum = true;
            } catch (NumberFormatException e) {
                //e.printStackTrace();
            }
            if (isNum) {
                stack.push(temp);
            } else {
                double s1 = stack.pop();
                double s2 = stack.pop();
                if ("+".equals(s)) {
                    stack.push(s2 + s1);
                } else if ("-".equals(s)) {
                    stack.push(s2 - s1);
                } else if ("*".equals(s)) {
                    stack.push(s2 * s1);
                } else if ("/".equals(s)) {
                    stack.push(s2 / s1);
                }
            }
        }
        if (!stack.isEmpty()) {
            return stack.pop();
        }
        return 0.0;
    }

    public static double calc(String expression) throws Exception {
        List<String> rpn = convert2RPN(expression);
        return mainCalculate(rpn);
    }

    public static void main(String[] args) {

        /*String express = "-arg1+arg2*arg3-(-arg4/arg5-temp1)*arg6";
        //String express = "A+B*(C-D)/E+F/H";
        String express2 = "12 + 7 * (-5) - (9.4 - 2) * 0.1";
        List<String> result = convert2RPN(express);
        List<String> result2 = convert2RPN(express2);
        System.out.println(result);
        System.out.println(result2);

        double double2 = mainCalculate(result2);
        System.out.println(double2);
        */

        for (String s : testexpr) {
            try {
                double result = calc(s);
                System.out.println(s + " = " + result);
            } catch (Exception e) {
                System.out.println(s + ": 表达式有误");
            }
        }
    }
}
