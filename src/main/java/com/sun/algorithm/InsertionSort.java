package com.sun.algorithm;

/**
 * @Description:插入排序
 * @author: sunhuaquan
 * @Date: 2018-12-03 10:55
 */
public class InsertionSort implements Sort {

    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int k = i;
            int curr = arr[i];
            while (k > 0 && curr < arr[k - 1]) {
                arr[k] = arr[k - 1];
                k--;
            }
            arr[k] = curr;
        }
    }
}
