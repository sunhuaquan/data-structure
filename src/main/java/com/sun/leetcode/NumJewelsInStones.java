package com.sun.leetcode;


import java.util.ArrayList;
import java.util.List;

public class NumJewelsInStones {

    static class Solution {

        public int[] sortArrayByParityII(int[] A) {

            int[] result = new int[A.length];
            int index1 = 0;//偶数下标
            int index2 = 1;//奇数下标
            for (int i = 0; i < A.length; i++) {
                if (A[i] % 2 == 0) {
                    result[index1] = A[i];
                    index1 += 2;
                } else {
                    result[index2] = A[i];
                    index2 += 2;
                }
            }
            return result;
        }
    }


    public static void main(String[] args) {

        int[] ints = new Solution().sortArrayByParityII(new int[]{4, 2, 5, 7});

        for (int i : ints) {
            System.out.print(i + " ");
        }


    }

}
