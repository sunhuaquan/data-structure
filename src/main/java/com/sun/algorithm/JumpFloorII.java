package com.sun.algorithm;

import com.sun.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class JumpFloorII {

    int count = 0;

    public int jumpFloorII(int target) {
        LinkedList<Integer> result = new LinkedList<>();
        dfs(0, target, result);
        return count;
    }

    public void dfs(int sum, int target, LinkedList<Integer> result) {
        if (sum == target) {
            count++;
            System.out.println(result);
            return;
        }
        for (int i = 1; i <= target - sum; i++) {
            result.add(i);
            dfs(sum + i, target, result);
            result.removeLast();
        }
    }

    public int[] reOrderArray(int[] array) {
        // write code here
        int l = 0;
        int r = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                r++;
            }
        }
        r=array.length-r;
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                res[l++] = array[i];
            } else {
                res[r++] = array[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {

        int[] ints = new JumpFloorII().reOrderArray(new int[]{1, 2, 3, 4, 5, 6, 7});
        for (int i : ints) {
            System.out.print(i+ " ");
        }

        Queue<TreeNode> queue=new LinkedList<>();
    }



}
