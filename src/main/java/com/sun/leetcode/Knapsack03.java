package com.sun.leetcode;

/// 背包问题
/// 动态规划改进: 滚动数组
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(C), 实际使用了2*C的额外空间
public class Knapsack03 {


    public int knapsack01(int[] weight, int[] value, int capacity) {

        assert weight != null && value != null;
        assert weight.length > 0 && value.length > 0;
        assert weight.length == value.length;
        assert capacity > 0;
        int[][] dp = new int[2][capacity + 1];

        //只考虑第0个商品
        for (int i = 0; i < capacity + 1; i++) {
            if (weight[0] <= i) {
                dp[0][i] = value[0];
            }
        }
        //考虑第一个以后的每个商品
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j < capacity + 1; j++) {
                //考虑每个容量下的最大价值
                dp[i%2][j] = dp[(i - 1)%2][j];
                if (weight[i] <= j) {
                    dp[i%2][j] = Math.max(dp[i%2][j], value[i] + dp[(i - 1)%2][j - weight[i]]);
                }
            }
        }
        return dp[(weight.length-1)%2][capacity];
    }


    public static void main(String[] args) {

        int i = new Knapsack03().knapsack01(new int[]{2, 1, 3}, new int[]{4, 2, 3}, 4);
        System.out.println(i);
    }

}
