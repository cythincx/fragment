package com.chengyuxing.fragment.algorithm;

import static com.chengyuxing.fragment.util.PrintUtils.print;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/7
 * Time: 上午11:33
 * Description:
 * 选择排序
 */
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        if (arr.length <= 1)
            return;
        int min, index;
        for (int i = 0; i < arr.length; i++) {
            min = arr[i];
            index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    index = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[index] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 6, 4, 7, 1, 3, 8, 0, 5, 9, 0, 12, 3, -5, 1, 99, 47, 56, 33, 1, 0};
        SelectionSort.selectionSort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            print(arr1[i] + " ");
        }
    }
}
