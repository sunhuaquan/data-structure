package com.sun.leetcode;

/// 背包问题
/// 记忆化搜索
/// 时间复杂度: O(n * C) 其中n为物品个数; C为背包容积
/// 空间复杂度: O(n * C)
public class Knapsack01 {

    private int[][] memo;

    public int knapsack01(int[] weight, int[] value, int capacity) {

        int index = weight.length - 1;
        memo = new int[weight.length][capacity + 1];
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                memo[i][j] = -1;
            }
        }

        int bastValue = bastValue(weight, value, index, capacity);
        return bastValue;
    }

    private int bastValue(int[] weight, int[] value, int index, int capacity) {
        if (index < 0 || weight[index] > capacity) {
            return 0;
        }
        if (memo[index][capacity] != -1) {
            return memo[index][capacity];
        }
        //不放当前商品
        int result = bastValue(weight, value, index - 1, capacity);
        if (weight[index] <= capacity) {
            //放当前商品
            int currValue = value[index] + bastValue(weight, value, index - 1, capacity - weight[index]);
            result = Math.max(result, currValue);
        }
        memo[index][capacity] = result;
        return result;
    }

    public static void main(String[] args) {

        int i = new Knapsack01().knapsack01(new int[]{2, 1, 3}, new int[]{4, 2, 3}, 4);
        System.out.println(i);
    }

}
