package com.sun.algorithm;


import java.util.Arrays;

public class Interview48 {

    private static int findLongestSubstringLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int maxLength = 0;
        int currLength = 0;
        int[] position = new int[26];
        Arrays.fill(position, -1);
        for (int i = 0; i < chars.length; i++) {
            int index = chars[i] - 'a';
            int prePosition = position[index];
            int distance = i - prePosition;
            if (prePosition < 0 || distance > currLength) {
                currLength++;
            } else {
                maxLength = Math.max(currLength, maxLength);
                currLength = distance;
            }
            position[index]=i;
        }
        maxLength = Math.max(currLength, maxLength);
        return maxLength;
    }

    public static void main(String[] args) {

        System.out.println(Interview48.findLongestSubstringLength("arabcacfr"));
    }

    public static void print(int[] p) {

        for (int i = 0; i < p.length; i++) {
            System.out.print("\t" + i + ":[" + p[i] + "]");
        }
        System.out.print("\n");
    }

}
