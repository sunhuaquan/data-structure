package com.sun.algorithm;


public class Interview53_2 {


    public static void main(String[] args) {

        int[] data = new int[]{0, 1, 2, 3, 4, 6, 7, 8,9,10,11,12,13,14};
        int i = getMissingNumber(data, 0, data.length - 1);
        System.out.println(i);
    }

    public static int getMissingNumber(int[] data, int begin, int end) {

        System.out.println("begin="+begin+" end="+end);
        int mid = begin + ((end - begin) >> 1);
        if (data[mid] == mid) {
            //mid 前面都是正常的
            return getMissingNumber(data, mid + 1, end);
        } else {
            if (data[mid - 1] == mid-1) {
                return mid;
            } else {
                return getMissingNumber(data, begin, mid - 1);
            }
        }
    }


}
