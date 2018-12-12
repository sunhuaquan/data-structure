package com.sun.zcy;


import java.util.*;

/**
 * @author sunhuaquan
 * @Title: MedianHolder
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/12/9 10:05
 */
public class MedianHolder {

    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new MaxCompator());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new MinCompator());

    private void modifyTwoHeapsSize() {
        if (this.maxHeap.size() == this.minHeap.size() + 2) {
            this.minHeap.add(this.maxHeap.poll());
        }
        if (this.minHeap.size() == this.maxHeap.size() + 2) {
            this.maxHeap.add(this.minHeap.poll());
        }
    }

    public void add(int num) {
        if (this.maxHeap.isEmpty()) {
            this.maxHeap.add(num);
            return;
        }
        if (this.maxHeap.peek() >= num) {
            this.maxHeap.add(num);
        } else {
            if (this.minHeap.isEmpty()) {
                this.minHeap.add(num);
                return;
            }
            if (this.minHeap.peek() > num) {
                this.maxHeap.add(num);
            } else {
                this.minHeap.add(num);
            }
        }
        modifyTwoHeapsSize();
    }

    public int getMedia() {
        //奇数
        if (((maxHeap.size() + minHeap.size()) & 1) != 0) {
            return maxHeap.size() > minHeap.size() ? maxHeap.peek() : minHeap.peek();
        } else {
            return (maxHeap.peek() + minHeap.peek()) / 2;
        }
    }


    public static class MaxCompator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 > o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static class MinCompator implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            if (o2 < o1) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    // for test
    public static int[] getRandomArray(int maxLen, int maxValue) {
        int[] res = new int[(int) (Math.random() * maxLen) + 1];
        for (int i = 0; i != res.length; i++) {
            res[i] = (int) (Math.random() * maxValue);
        }
        return res;
    }
    // for test, this method is ineffective but absolutely right
    public static int getMedianOfArray(int[] arr) {
        int[] newArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(newArr);
        int mid = (newArr.length - 1) / 2;
        if ((newArr.length & 1) == 0) {
            return (newArr[mid] + newArr[mid + 1]) / 2;
        } else {
            return newArr[mid];
        }
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {

        boolean err = false;
        int testTimes = 200000;
        for (int i = 0; i != testTimes; i++) {
            int len = 30;
            int maxValue = 1000;
            int[] arr = getRandomArray(len, maxValue);
            MedianHolder medianHold = new MedianHolder();
            for (int j = 0; j != arr.length; j++) {
                medianHold.add(arr[j]);
            }
            if (medianHold.getMedia() != getMedianOfArray(arr)) {
                err = true;
                printArray(arr);
                break;
            }
        }
        System.out.println(err ? "Oops..what a fuck!" : "today is a beautiful day^_^");
    }
}
