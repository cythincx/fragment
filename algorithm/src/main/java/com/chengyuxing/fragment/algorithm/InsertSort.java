package com.chengyuxing.fragment.algorithm;

import static com.chengyuxing.fragment.util.PrintUtils.print;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/7
 * Time: 下午2:15
 * Description:
 * 插入排序
 */
public class InsertSort {
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            int current = arr[i];
            while (j >= 0 && arr[j] > current) {
                arr[j + 1] = arr[j];
                arr[j] = current;
                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 6, 4, 7, 1, 3, 8, 0, 5, 9, 0, 12, 3, -5, 1, 99, 47, 56, 33, 1, 0};
        InsertSort.insertSort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            print(arr1[i] + " ");
        }
    }
}
