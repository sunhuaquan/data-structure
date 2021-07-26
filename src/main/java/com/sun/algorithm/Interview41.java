package com.sun.algorithm;


import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Random;

public class Interview41 {


    public static void main(String[] args) {

        Median median = new Median();
        int count = 10;
        int data[] = new int[count];

        Random random = new Random();
        for (int i = 0; i < count; i++) {

            int number = random.nextInt(10);
            data[i] = number;
            median.insert(number);

        }
        double median1 = median.getMedian();
        Arrays.sort(data);
        for (int d : data) {
            System.out.print(d + " ");
        }
        System.out.print("\n");
        System.out.println(median1);
    }


    public static class Median {

        private int size = 0;
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        public void insert(int val) {

            size++;
            //minHeap放偶数且最大的
            if ((size & 0X1) == 0) {
                //比最大还小
                if (!maxHeap.isEmpty() && maxHeap.peek() > val) {
                    maxHeap.offer(val);
                    val = maxHeap.poll();
                }
                minHeap.offer(val);
            } else {
                //maxHeap奇数且最小的
                if (!minHeap.isEmpty() && minHeap.peek() < val) {
                    minHeap.offer(val);
                    val = minHeap.poll();
                }
                maxHeap.offer(val);
            }
        }

        public double getMedian() {

            if (size == 0) {
                throw new RuntimeException("no sufficiant number");
            }
            if ((size & 0x1) == 0) {
                return (maxHeap.peek() + minHeap.peek()) / 2.0;
            } else {
                return maxHeap.peek();
            }

        }
    }
}
