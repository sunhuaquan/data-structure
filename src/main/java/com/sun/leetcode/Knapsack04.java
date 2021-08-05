package com.sun.leetcode;

/// 背包问题
/// 动态规划改进
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(C), 只使用了C的额外空间
public class Knapsack04 {


    public int knapsack01(int[] weight, int[] value, int capacity) {

        assert weight != null && value != null;
        assert weight.length > 0 && value.length > 0;
        assert weight.length == value.length;
        assert capacity > 0;
        int[] dp = new int[capacity + 1];
        //只考虑第0个商品
        for (int i = 0; i < capacity + 1; i++) {
            if (weight[0] <= i) {
                dp[i] = value[0];
            }
        }
        //考虑第一个以后的每个商品
        for (int i = 1; i < weight.length; i++) {
            for (int j = capacity; j >= weight[i]; j--) {
                //考虑每个容量下的最大价值
                dp[j] = Math.max(dp[j], value[i] + dp[j - weight[i]]);
            }
        }
        return dp[capacity];
    }
    public static void main(String[] args) {

        int i = new Knapsack04().knapsack01(new int[]{2, 1, 3}, new int[]{4, 2, 3}, 4);
        System.out.println(i);
    }

}
