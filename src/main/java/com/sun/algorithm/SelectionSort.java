package com.sun.algorithm;

/**
 * @Description:选择排序
 * @author: sunhuaquan
 * @Date: 2018-12-03 11:13
 */
public class SelectionSort implements Sort {


    @Override
    public void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = min;
            arr[minIndex] = temp;
        }
    }
}
