package com.sun.algorithm;

/**
 * @Description:冒泡排序
 * @author: sunhuaquan
 * @Date: 2018-12-03 10:32
 */
public class BubbleSort implements Sort {

    @Override
    public void sort(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                }
            }
        }
    }
}
