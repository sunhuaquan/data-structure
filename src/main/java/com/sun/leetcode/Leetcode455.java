package com.sun.leetcode;

import java.util.Arrays;

public class Leetcode455 {

    /**
     * @param g 胃口值
     * @param s 饼干大小
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int minIndex = 0;
        int result = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j = minIndex; j < s.length; j++) {
                if (s[j] >= g[i]) {
                    result++;
                    minIndex = j+1;
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {

        int contentChildren = new Leetcode455().findContentChildren(new int[]{1, 2,}, new int[]{1, 2,3});
        System.out.println(contentChildren);
    }
}
