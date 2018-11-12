package com.sun.test;

import com.sun.util.MaxHeap;

public class MaxHeapTest {

    public static void main(String[] args) {

        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Integer[] nums = new Integer[]{10, 20, 18, 30, 40, 56, 12};
        for (int i = 0; i < nums.length; i++)
            maxHeap.add(nums[i]);
        while (!maxHeap.isEmpty()) {
            Integer integer = maxHeap.extractMax();
            System.out.print(integer + " ");
        }
        System.out.println();
        maxHeap = new MaxHeap<>(nums);
        while (!maxHeap.isEmpty()) {
            Integer integer = maxHeap.extractMax();
            System.out.print(integer + " ");
        }
    }
}
