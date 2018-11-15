package com.sun.test;

import com.sun.util.IndexMaxHeap;

/**
 * @author sunhuaquan
 * @Title: IndexMaxHeapTest
 * @ProjectName data-structure
 * @Description: test
 * @date 2018/11/1422:00
 */
public class IndexMaxHeapTest {

    public static void main(String[] args) {

        IndexMaxHeap<Integer> indexMaxHeap = new IndexMaxHeap<>(Integer.class, 10);
        int[] data = new int[]{21, 32, 43, 56, 30, 45, 34, 7, 3, 9};
        for (int i = 0; i < 10; i++) {
            indexMaxHeap.insert(i, data[i]);
        }

        for (int i = 0; i < 10; i++) {
            Integer extractMax = indexMaxHeap.extractMax();
            System.out.println(extractMax);
        }
    }
}
