package com.sun.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode46 {

    List<List<Integer>> result;
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {

        if (nums == null || nums.length == 0) {
            return null;
        }
        result = new ArrayList<>();
        used = new boolean[nums.length];
        permute(nums, 0, new LinkedList<Integer>());
        return result;
    }

    private void permute(int[] nums, int index, LinkedList<Integer> val) {

        if (index == nums.length) {
            result.add((List<Integer>) val.clone());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(!used[i]){
                used[i]=true;
                val.addLast(nums[i]);
                permute(nums,index+1,val);
                used[i]=false;
                val.removeLast();
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> permute = new Leetcode46().permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }
}
