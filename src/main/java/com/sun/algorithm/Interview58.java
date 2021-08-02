package com.sun.algorithm;


public class Interview58 {


    public static void main(String[] args) {

        String val = "i am a student.";
        String reverse = reverseWord(val.toCharArray());
        System.out.println(reverse);

    }

    public static void reverse(char[] val, int begin, int end) {
        while (begin < end) {
            char tmp = val[begin];
            val[begin] = val[end];
            val[end] = tmp;
            begin++;
            end--;
        }

    }

    public static String reverseWord(char[] val) {

        reverse(val, 0, val.length - 1);
        int begin = 0;
        int end = 0;
        while (end < val.length) {
            if (val[begin] == ' ') {
                begin++;
                end++;
            } else if (val[end] == ' ') {
                reverse(val, begin, end - 1);
                begin=++end;
            } else {
                end++;
            }

        }
        return new String(val);
    }
}
