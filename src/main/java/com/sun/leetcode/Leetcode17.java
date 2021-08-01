package com.sun.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Leetcode17 {


    static String[] leeters = new String[]{
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "qprs",
            "tuv",
            "wxyz"
    };

    List<String> result;

    public List<String> letterCombinations(String digits) {

        if (digits == null || digits.length() == 0) {
            return null;
        }
        result = new ArrayList<>();
        letterCombinations(digits, 0, new LinkedList<>());
        return result;
    }

    private void letterCombinations(String digits, int index, LinkedList<String> val) {
        if (index == digits.length()) {
            result.add(val.stream().collect(Collectors.joining()));
            return;
        }
        char c = digits.charAt(index);
        String le = leeters[c - '0'];
        for (int i = 0; i < le.length(); i++) {
            val.addLast(String.valueOf(le.charAt(i)));
            letterCombinations(digits, index + 1, val);
            val.removeLast();
        }
    }

    public static void main(String[] args) {

        List<String> list = new Leetcode17().letterCombinations("234");
        System.out.println(list);
    }
}
