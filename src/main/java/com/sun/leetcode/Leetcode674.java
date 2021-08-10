package com.sun.leetcode;

public class Leetcode674 {


    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 0;
        int currCount = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                currCount++;
            } else {
                max = Math.max(max, currCount);
                currCount = 1;
            }
        }
        max = Math.max(max, currCount);
        return max;
    }

    public static void main(String[] args) {

        int i = new Leetcode674().findLengthOfLCIS(new int[]{2,2,2,2,2});
        System.out.println(i);
    }
}
