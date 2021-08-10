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
        int child = 0;
        int cookie = 0;
        while (child < g.length && cookie < s.length) {
            if (s[cookie] >= g[child]) {
                child++;
            }
            cookie++;
        }
        return child;
    }

    public static void main(String[] args) {

        int contentChildren = new Leetcode455().findContentChildren(new int[]{1, 2,}, new int[]{1, 2, 3});
        System.out.println(contentChildren);
    }
}
