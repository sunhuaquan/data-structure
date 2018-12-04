package com.sun.algorithm;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-12-03 11:32
 */
public class BinarySearch {

    public int search(int[] sortArr, int value) {

        int left = 0;
        int right = sortArr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (sortArr[mid] == value) {
                return mid;
            } else if (sortArr[mid] > value) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
