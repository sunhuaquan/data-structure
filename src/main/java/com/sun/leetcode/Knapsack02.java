package com.sun.leetcode;

/// 背包问题
/// 动态规划
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(n * C)
public class Knapsack02 {


    /**
     *
     * @param weight
     * @param value
     * @param capacity
     * @return
     */
    public int knapsack01(int[] weight, int[] value, int capacity) {

        assert weight != null && value != null;
        assert weight.length > 0 && value.length > 0;
        assert weight.length == value.length;
        assert capacity > 0;
        int[][] dp = new int[weight.length][capacity + 1];

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

                //不放当前商品
                dp[i][j] = dp[i - 1][j];
                if (weight[i] <= j) {
                    //放当前商品
                    dp[i][j] = Math.max(dp[i][j], value[i] + dp[i - 1][j - weight[i]]);
                }
            }
        }
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.print("\n");
        }
        return dp[weight.length-1][capacity];
    }


    public static void main(String[] args) {

        int i = new Knapsack02().knapsack01(new int[]{2, 1, 3}, new int[]{4, 2, 3}, 4);
        System.out.println(i);
    }

}
