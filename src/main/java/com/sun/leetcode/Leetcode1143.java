package com.sun.leetcode;

import java.util.Arrays;

public class Leetcode1143 {

    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return longestCommonSubsequence(text1, text1.length() - 1, text2, text2.length() - 1);
    }


    public int longestCommonSubsequence(String text1, int index1, String text2, int index2) {

        if (index1 < 0 || index2 < 0) {
            return 0;
        }
        if (memo[index1][index2] != -1) {
            return memo[index1][index2];
        }
        if (text1.charAt(index1) == text2.charAt(index2)) {
            memo[index1][index2]= 1 + longestCommonSubsequence(text1, index1 - 1, text2, index2 - 1);
            return memo[index1][index2];
        } else {
            memo[index1][index2]= Math.max(longestCommonSubsequence(text1, index1 - 1, text2, index2)
                    , longestCommonSubsequence(text1, index1, text2, index2 - 1));
            return memo[index1][index2];
        }
    }


    public int lcs(String s1, String s2){

        int m = s1.length();
        int n = s2.length();

        // 对memo的第0行和第0列进行初始化
        int[][] memo = new int[m][n];
        for(int j = 0 ; j < n ; j ++)
            if(s1.charAt(0) == s2.charAt(j)){
                for(int k = j ; k < n ; k ++)
                    memo[0][k] = 1;
                break;
            }

        for(int i = 0 ; i < m ; i ++)
            if(s1.charAt(i) == s2.charAt(0)) {
                for(int k = i ; k < m ; k ++)
                    memo[k][0] = 1;
                break;
            }

        // 动态规划的过程
        for(int i = 1 ; i < m ; i ++)
            for(int j = 1 ; j < n ; j ++)
                if(s1.charAt(i) == s2.charAt(j))
                    memo[i][j] = 1 + memo[i-1][j-1];
                else
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);

        return memo[m-1][n-1];
    }

    public static void main(String[] args) {

        int i = new Leetcode1143().lcs("abc", "def");
        System.out.println(i);
    }
}
