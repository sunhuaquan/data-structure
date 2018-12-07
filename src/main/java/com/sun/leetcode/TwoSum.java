package com.sun.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                int num2 = target - nums[i];
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == num2) {
                        return new int[]{i, j};
                    }
                }
            }
            return null;
        }

        public int[] twoSum2(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int num2 = target - nums[i];
                if (map.containsKey(num2)) {
                    return new int[]{map.get(num2), i};
                }
                map.put(nums[i], i);
            }
            return null;
        }
    }

    public static void main(String[] args) {

        int[] nums = new int[]{1, 2, 3};
        int target = 3;
        int[] result = new Solution().twoSum2(nums, target);
        for (int item : result) {
            System.out.print(item + " ");
        }

    }
}



