package com.sun.leetcode;

public class Leetcode198 {

    public int rob(int[] nums) {

        if(nums==null||nums.length==0){
            throw new RuntimeException("nums is empty");
        }
        int[] memo = new int[nums.length];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            memo[i] = Math.max(nums[i] + memo[i - 2], memo[i - 1]);
        }
        return memo[nums.length - 1];
    }

    public static void main(String[] args) {

        System.out.println((new Leetcode198()).rob(new int[]{1, 2, 3, 1}));
        System.out.println((new Leetcode198()).rob(new int[]{2, 7, 9, 3, 1}));
    }
}
