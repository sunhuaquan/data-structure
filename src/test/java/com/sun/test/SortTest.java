package com.sun.test;

import com.sun.algorithm.BubbleSort;
import com.sun.algorithm.HeapSort;
import com.sun.algorithm.MergeSort;
import com.sun.algorithm.QuickSort;
import com.sun.algorithm.Sort;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-12-03 10:45
 */
public class SortTest {

    public static void main(String[] args) {

        Sort sort = new BubbleSort();
        int[] arr = new int[]{10, 1, 20, 4, 5, 7, 2, 3};
        sort.sort(arr);
        for (int v : arr) {
            System.out.print(v + " ");
        }
     /*   BinarySearch binarySearch = new BinarySearch();
        int search = binarySearch.search(arr, 4);
        System.out.print("\n");
        System.out.println(search);*/
    }
}
