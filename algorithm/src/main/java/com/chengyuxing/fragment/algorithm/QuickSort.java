package com.chengyuxing.fragment.algorithm;

import static com.chengyuxing.fragment.util.PrintUtils.print;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/7
 * Time: 下午4:28
 * Description:
 */
public class QuickSort {
    public static void quickSort(int[] arr, int start, int end) {
        if (arr == null || arr.length <= 1)
            return;
        if (start >= end)
            return;
        int p = arr[start];
        int i = start, j = end;
        while (i < j) {
            while (i < j && arr[j] >= p) j--;
            if (i < j)
                arr[i++] = arr[j];
            while (i < j && arr[i] <= p) i++;
            if (i < j)
                arr[j--] = arr[i];
        }
        arr[i] = p;
        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        QuickSort.quickSort(arr1, 0, arr1.length - 1);
        for (int i = 0; i < arr1.length; i++) {
            print(arr1[i] + " ");
        }
    }
}
