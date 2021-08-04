package com.sun.leetcode;

public class Leetcode343 {

    public int integerBreak(int n) {

        if (n < 0) {
            return -1;
        }
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                memo[i] = max(memo[i], j * (i - j), j * memo[i - j]);
            }

        }
        return memo[n];

    }

    public int max(int a, int b, int c) {

        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {

        System.out.println((new Leetcode343()).integerBreak(2));
        System.out.println((new Leetcode343()).integerBreak(10));
    }
}
