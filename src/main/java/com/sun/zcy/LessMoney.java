package com.sun.zcy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author sunhuaquan
 * @Title: LessMoney
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/12/9 20:56
 */
public class LessMoney {

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();


    public static int lessMoney(int[] arr) {

        if (arr == null || arr.length == 0) {
            throw new RuntimeException("arr is empty");
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinCompare());
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }
        while (minHeap.size() > 1) {
            minHeap.add(minHeap.poll() + minHeap.poll());
        }
        return minHeap.poll();

    }

    public static class MinCompare implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 < o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) {
        int i = lessMoney(new int[]{10, 20, 30});
        System.out.print(i);
    }


}
