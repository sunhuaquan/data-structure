package com.sun.algorithm;


public class Interview57 {


    public static void main(String[] args) {

        int[] numsAppearOnce = findNumsWithSum(new int[]{1, 2, 4, 7, 11, 15}, 15);
        for (int i = 0; i < numsAppearOnce.length; i++) {
            System.out.println(numsAppearOnce[i]);
        }
    }


    public static int[] findNumsWithSum(int[] data, int sum) {

        if(data==null||data.length==0){
            return null;
        }
        int[] result = new int[]{0, 0};
        int i = 0;
        int j = data.length - 1;
        while (i < j) {
            int currSum = data[i] + data[j];
            if (currSum == sum) {
                result[0] = data[i];
                result[1] = data[j];
                return result;
            }
            if (currSum > sum) {
                j--;
            } else {
                i++;
            }
        }
        return null;
    }
}
