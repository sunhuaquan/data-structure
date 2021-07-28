package com.sun.algorithm;


public class Interview53 {


    public static void main(String[] args) {

        int i = getNumberOfK(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3}, 3);
        System.out.println(i);
    }

    public static int getNumberOfK(int[] data, int k) {

        if (data == null || data.length == 0) {
            return 0;
        }
        return getNumberOfK(data, 0, data.length - 1, k);
    }


    public static int getNumberOfK(int[] data, int begin, int end, int k) {
        if (begin >= end) {
            return 0;
        }
        int mid = begin + ((end - begin) >> 1);
        if (data[mid] > k) {
            getNumberOfK(data, begin, mid - 1, k);
        } else if (data[mid] < k) {
            getNumberOfK(data, mid + 1, end, k);
        } else {
            int first = getFirstNumberOfK(data, begin, mid, k);
            int last = getLastNumberOfK(data, mid, end, k);
            return last - first + 1;
        }
        return 0;
    }

    public static int getFirstNumberOfK(int[] data, int begin, int end, int k) {
        if (end == 0) {
            return end;
        }
        if (data[end - 1] != k) {
            return end;
        }
        int mid = begin + ((end - begin) >> 1);
        //
        if (data[mid] < k) {
            return getFirstNumberOfK(data, mid + 1, end, k);
        } else {
            return getFirstNumberOfK(data, begin, mid, k);
        }
    }

    public static int getLastNumberOfK(int[] data, int begin, int end, int k) {
        System.out.println("begin="+begin+" end="+end);
        if (begin == data.length - 1) {
            return begin;
        }
        if (data[begin + 1] != k) {
            return begin;
        }
        int mid = begin + ((end - begin) >> 1)+1;
        //在右边找
        if (data[mid] > k) {
            return getLastNumberOfK(data, begin, mid - 1, k);
        } else {
            return getLastNumberOfK(data, mid, end, k);
        }
    }
}
