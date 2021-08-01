package com.sun.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leetcode77 {

    List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k) {

        if (n <= 0 || k <= 0) {
            return null;
        }
        result = new ArrayList<>();
        combine(n, k, 1, 0, new LinkedList<Integer>());
        return result;
    }

    private void combine(int n, int k, int index, int start, LinkedList<Integer> val) {
        if (index == k + 1) {
            result.add((List<Integer>) val.clone());
            return;
        }
        for (int i = start+1; i <= n; i++) {
            val.addLast(i);
            combine(n, k, index + 1, i, val);
            val.removeLast();
        }
    }
    public static void main(String[] args) {

        List<List<Integer>> combine = new Leetcode77().combine(20, 16);
        System.out.println(combine);
    }
}
