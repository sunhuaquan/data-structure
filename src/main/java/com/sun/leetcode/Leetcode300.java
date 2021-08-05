package com.sun.leetcode;

public class Leetcode300 {

    public int lengthOfLIS(int[] nums) {

        assert nums != null;

        int[] memo = new int[nums.length];
        for (int i = 0; i < memo.length; i++) {
            memo[i] = 1;
        }
        for (int i = 0; i < memo.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    memo[i] = Math.max(memo[i], memo[j] + 1);
                }
            }
        }
        int result = 1;
        for (int i = 0; i < memo.length; i++) {
            result = Math.max(result, memo[i]);
        }
        return result;
    }

    public static void main(String[] args) {

        int i = new Leetcode300().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        System.out.println(i);
    }
}
