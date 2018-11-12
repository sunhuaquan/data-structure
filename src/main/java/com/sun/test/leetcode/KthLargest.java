package com.sun.test.leetcode;

import java.util.ArrayList;

public class KthLargest {

    class MinHeap<E extends Comparable<E>> {

        private ArrayList<E> data;

        public MinHeap() {
            data = new ArrayList<>();
        }

        public MinHeap(E[] arr) {
            data = new ArrayList<>();
            for (int i = 0; i < arr.length; i++)
                data.add(arr[i]);

            for (int i = parent(arr.length - 1); i >= 0; i--)
                siftDown(i, data.get(i));
        }

        public int size() {
            return data.size();
        }

        public boolean isEmpty() {
            return data.size() == 0;
        }

        public E front() {
            if (data.isEmpty())
                throw new RuntimeException("data is empty");
            return data.get(0);
        }

        /**
         * 将元素e入堆
         *
         * @param e
         */
        public void enqueue(E e) {
            data.add(e);
            siftUp(data.size() - 1, e);
        }

        public int parent(int index) {

            if (index == 0)
                throw new IllegalArgumentException("index is not illegal");
            return (index - 1) / 2;
        }

        public int leftChild(int index) {
            return 2 * index + 1;
        }

        public int rightChild(int index) {
            return 2 * index + 2;
        }

        public void siftUp(int index, E e) {
            while (index > 0 && data.get(parent(index)).compareTo(e) > 0) {
                data.set(index, data.get(parent(index)));
                index = parent(index);
            }
            data.set(index, e);
        }

        /**
         * 取出对顶元素
         *
         * @return
         */
        public E dequeue() {
            E front = data.get(0);
            E e = data.remove(data.size() - 1);
            siftDown(0, e);
            return front;
        }

        public void siftDown(int index, E e) {
            if (data.isEmpty()) return;
            while (leftChild(index) < data.size()) {
                int j = leftChild(index);
                if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) < 0) {
                    j++;
                }
                if (e.compareTo(data.get(j)) < 0)
                    break;
                data.set(index, data.get(j));
                index = j;
            }
            data.set(index, e);
        }

        // 取出堆中的最大元素，并且替换成元素e
        public E replace(E e) {
            E ret = front();
            data.set(0, e);
            siftDown(0, e);
            return ret;
        }

    }

    private MinHeap<Integer> minHeap;

    private int k;

    public KthLargest(int k, int[] nums) {

        minHeap = new MinHeap<>();
        this.k = k;
        if (k < nums.length) {
            for (int i = 0; i < k; i++) {
                minHeap.enqueue(nums[i]);
            }
            for (int i = k; i < nums.length; i++) {
                if (minHeap.front().compareTo(nums[i]) < 0) {
                    minHeap.dequeue();
                    minHeap.enqueue(nums[i]);
                }
            }
        } else {  //k>nums.length;
            for (int i = 0; i < nums.length; i++) {
                minHeap.enqueue(nums[i]);
            }
        }
    }

    public int add(int val) {
        if (minHeap.size() < k) {
            minHeap.enqueue(val);
            return minHeap.front();
        }
        if (minHeap.front().compareTo(val) < 0) {
            minHeap.replace(val);
        }
        return minHeap.front();
    }
}
