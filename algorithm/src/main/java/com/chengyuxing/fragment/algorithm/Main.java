package com.chengyuxing.fragment.algorithm;

import java.util.Random;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/7
 * Time: 下午1:04
 * Description:
 */
public class Main {
    public static void main(String[] args) {

        int[] arr1 = new int[60000];
        Random rand = new Random(47);

        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rand.nextInt(1000000) - 1000;
        }
        int[] arr2 = null;
        arr2 = copyIntArr(arr1);
        int[] arr3 = copyIntArr(arr1);
        long startTime, endTime;

        println("各种排序算法演练");

        /*
        println("选择排序开始");
        startTime=System.currentTimeMillis();
        SelectionSort.selectionSort(arr1);
        endTime=System.currentTimeMillis();


        for (int i = 0; i < arr1.length; i++) {
            println(arr1[i] + " ");
        }
        println("选择排序共用时:" + (endTime - startTime) + "ms");
        */

        /*
        println("插入排序开始");
        startTime=System.currentTimeMillis();
        InsertSort.insertSort(arr1);
        endTime=System.currentTimeMillis();

//        for (int i = 0; i < arr1.length; i++) {
//            println(arr1[i] + " ");
//        }
        println("选择排序共用时:" + (endTime - startTime) + "ms");
        */


        /*
        println("冒泡排序开始");
        startTime=System.currentTimeMillis();
        BubbleSort.bubbleSort(arr1);
        endTime=System.currentTimeMillis();

        for (int i = 0; i < arr1.length; i++) {
            println(arr1[i] + " ");
        }
        println("冒泡排序共用时:" + (endTime - startTime) + "ms");
        */


        ///*
        println("希尔排序开始");
        startTime = System.currentTimeMillis();
        ShellSort.shellSort(arr2);
        endTime = System.currentTimeMillis();

//        for (int i = 0; i < arr1.length; i++) {
//            println(arr2[i] + " ");
//        }
        println("希尔排序共用时:" + (endTime - startTime) + "ms");
        //*/

        println("快速排序开始");
        startTime = System.currentTimeMillis();
        QuickSort.quickSort(arr3, 0, arr3.length - 1);
        endTime = System.currentTimeMillis();

//        for (int i = 0; i < arr1.length; i++) {
//            println(arr2[i] + " ");
//        }
        println("快速排序共用时:" + (endTime - startTime) + "ms");


    }

    private static int[] copyIntArr(int[] arr) {
        //result = new int[arr.length];
        int[] result = new int[0];
//        result = Arrays.copyOf(result, arr.length);
//        for (int i = 0; i < arr.length; i++) {
//            result[i] = arr[i];
//        }
        return result;
    }
}
