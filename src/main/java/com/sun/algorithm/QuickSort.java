package com.sun.algorithm;

/**
 * @Description:快速排序的基本思想：通过一趟排序将待排记录分隔成独立的两部分， 其中一部分记录的关键字均比另一部分的关键字小，
 * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。使用双指针实现
 * @author: sunhuaquan
 * @Date: 2018-12-03 11:46
 */
public class QuickSort implements Sort {
    @Override
    public void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int curr = arr[left];
            int i = left;
            int j = right;
            while (i != j) {
                while (i < j && arr[j] > curr) {
                    j--;
                }
                arr[i] = arr[j];
                while (i < j && arr[i] < curr) {
                    i++;
                }
                arr[j] = arr[i];
            }
            arr[i] = curr;
            quickSort(arr, left, i - 1);
            quickSort(arr, i + 1, right);
        }
    }
}
