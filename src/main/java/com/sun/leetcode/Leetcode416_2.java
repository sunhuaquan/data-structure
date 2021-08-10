package com.sun.leetcode;

/**
 * 动态规划
 */
public class Leetcode416_2 {


    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        int C = sum / 2;

        boolean[] memo = new boolean[C + 1];
        for(int i = 0 ; i <= C ; i ++) {
            memo[i] = (nums[0] == i);
        }

        for(int i = 1 ; i < n ; i ++) {
            for(int j = C; j >= nums[i] ; j --) {
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }
        return memo[C];
    }



    public static void main(String[] args) {

        boolean i = new Leetcode416_2().canPartition(new int[]{1, 5, 11, 5});
        System.out.println(i);
        i = new Leetcode416_2().canPartition(new int[]{1, 2, 3, 5});

        System.out.println(i);
    }
}
