package com.chengyuxing.fragment.algorithm;

import static com.chengyuxing.fragment.util.PrintUtils.print;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/7
 * Time: 下午6:37
 * Description:
 */
public class MergeSort {
    public static void merge_sort_recursive(int[] arr, int[] result, int start, int end) {
        if (start >= end)
            return;
        int len = end - start, mid = (len >> 1) + start;
        int start1 = start, end1 = mid;
        int start2 = mid + 1, end2 = end;
        merge_sort_recursive(arr, result, start1, end1);
        merge_sort_recursive(arr, result, start2, end2);
        int k = start;
        while (start1 <= end1 && start2 <= end2)
            result[k++] = arr[start1] < arr[start2] ? arr[start1++] : arr[start2++];
        while (start1 <= end1)
            result[k++] = arr[start1++];
        while (start2 <= end2)
            result[k++] = arr[start2++];
        for (k = start; k <= end; k++)
            arr[k] = result[k];
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 7, 8, 5, 2, 1, 9, 5, 4};
        int[] result = new int[arr1.length];
        MergeSort.merge_sort_recursive(arr1, result, 0, arr1.length - 1);
        for (int i = 0; i < arr1.length; i++) {
            print(arr1[i] + " ");
        }
    }
}
