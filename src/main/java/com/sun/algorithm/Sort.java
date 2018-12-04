package com.sun.algorithm;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-12-03 10:31
 */
public interface Sort {

    /**
     * 从小到大排序算法
     *
     * @param arr
     * @return
     */
    void sort(int[] arr);

    default void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
