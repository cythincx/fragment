package com.chengyuxing.fragment.algorithm;

import static com.chengyuxing.fragment.util.PrintUtils.print;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/7
 * Time: 下午2:28
 * Description:
 */
public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1)
            return;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 6, 4, 7, 1, 3, 8, 0, 5, 9, 0, 12, 3, -5, 1, 99, 47, 56, 33, 1, 0};
        BubbleSort.bubbleSort(arr1);
        for (int i = 0; i < arr1.length; i++) {
            print(arr1[i] + " ");
        }
    }
}
