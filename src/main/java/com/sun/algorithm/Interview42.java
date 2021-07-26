package com.sun.algorithm;


public class Interview42 {


    public static void main(String[] args) {

        int greatestSumOfArray = findGreatestSumOfArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5});
        System.out.println(greatestSumOfArray);
    }

    public static int findGreatestSumOfArray(int[] data) {

        int allSum = data[0];
        int subSum = data[0];
        for (int i = 1; i < data.length; i++) {
            subSum += data[i];
            if (subSum < 0) {
                subSum = 0;
            } else if (subSum > allSum) {
                allSum = subSum;
            }

        }
        return allSum;
    }
}
