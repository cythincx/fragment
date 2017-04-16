package com.chengyuxing.fragment.algorithm;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/7
 * Time: 下午3:32
 * Description:
 * 希尔排序
 */
public class ShellSort {
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        //gap 步长
        int gap = 1, i, j, len = arr.length;
        while (gap < len / 3) {
            gap = gap * 3 + 1; // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        }
        for (; gap > 0; gap /= 3) {
            for (i = gap; i < len; i++) {
                j = i - gap;
                int current = arr[i];
                while (j >= 0 && arr[j] > current) {
                    arr[j + gap] = arr[j];
                    arr[j] = current;
                    j -= gap;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 6, 4, 7, 1, 3, 8, 0, 5, 9, 0, 12, 3, -5, 1, 99, 47, 56, 33, 1, 0};
        ShellSort.shellSort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            println(arr1[i] + " ");
        }
    }
}
