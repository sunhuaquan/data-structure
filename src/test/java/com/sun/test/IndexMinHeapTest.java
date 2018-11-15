package com.sun.test;

import com.sun.util.IndexMaxHeap;
import com.sun.util.IndexMinHeap;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-11-15 10:16
 */
public class IndexMinHeapTest {


    public static void main(String[] args) {

        IndexMinHeap<Integer> indexMinHeap = new IndexMinHeap<>(Integer.class, 10);
        int[] data = new int[]{21, 32, 43, 56, 30, 45, 34, 7, 3, 9};
        for (int i = 0; i < 10; i++) {
            indexMinHeap.insert(i, data[i]);
        }

        for (int i = 0; i < 10; i++) {
            Integer extractMax = indexMinHeap.extractMin();
            System.out.println(extractMax);
        }
    }
}
