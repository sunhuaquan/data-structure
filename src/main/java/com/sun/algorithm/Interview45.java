package com.sun.algorithm;


import java.util.Arrays;
import java.util.Comparator;

public class Interview45 {

    public static String printMinNumber(int []numbers){
        if(numbers == null || numbers.length == 0){
            return "";
        }
        int len = numbers.length;
        String []str = new String[len];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            str[i] = String.valueOf(numbers[i]);
        }
        //这里根据自己定义的排序规则,新的排序规则,如若取最大值，~c1.compareTo(c2)
        Arrays.sort(str, new Comparator<String>() {
            public int compare(String str1, String str2) {
                String c1 = str1 + str2;
                String c2 = str2 + str1;
                return c1.compareTo(c2);
            }
        });
        for(int i = 0; i < len; i++){
            sb.append(str[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int a[] = {3, 32, 321};
        System.out.println(Interview45.printMinNumber(a));
    }

}
