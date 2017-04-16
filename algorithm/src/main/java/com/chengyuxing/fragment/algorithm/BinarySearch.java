package com.chengyuxing.fragment.algorithm;

import static com.chengyuxing.fragment.util.PrintUtils.println;

/**
 * Created with IntelliJ IDEA.
 * Author: chengyuxing
 * Date: 2016/11/28
 * Time: 下午5:35
 * Description:
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 7, 8, 9};
        println(BinarySearch.binarySearch(arr, 6));
        println(BinarySearch.binarySearch(arr, 6, 0, arr.length - 1));
    }

    /**
     * 如果找到元素,返回坐标
     * 如果找不到元素,返回-1
     *
     * @param arr
     * @param des
     * @return
     */
    public static int binarySearch(int[] arr, int des) {
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int middlePoint = (low + high) / 2;
            int middle = arr[middlePoint];
            if (des == middle)
                return middlePoint;
            else if (des > middle) {
                low = middlePoint + 1;
            } else {
                high = middlePoint - 1;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int desc, int start, int end) {
        int middlePoint = (start + end) / 2;
        int middle = arr[middlePoint];
        if (middle < arr[start] || middle > arr[end] || start > end)
            return -1;
        if (middle == desc)
            return middlePoint;
        else if (desc < middle)
            return binarySearch(arr, desc, start, middlePoint - 1);
        else
            return binarySearch(arr, desc, middlePoint + 1, end);
    }
}
