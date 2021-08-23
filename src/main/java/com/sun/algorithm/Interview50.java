package com.sun.algorithm;

import java.util.LinkedHashMap;

public class Interview50 {

    public static char FirstNotRepeatingChar(String str) {
        if(str == null || str.length() == 0)
            return '0';
        char[] ch = str.toCharArray();
        LinkedHashMap<Character,Integer> hash = new LinkedHashMap<>();
        for(char item : ch){
            //倘若字符已存在，则字符对应的value+1操作即可。
            if(hash.containsKey(item))
                hash.put(item,hash.get(item)+1);
            else
                //倘若之前不存在该字符，放入hash中。
                hash.put(item,1);
        }
        //遍历整个hash，找满足要求的key，返回key所在位置。
        for(int i = 0; i < str.length(); i++){
            if(hash.get(str.charAt(i)) == 1){
                return str.charAt(i);
            }
        }
        return '0';
    }



    public static void main(String[] args) {

        System.out.println(Interview50.FirstNotRepeatingChar("abaccdeff"));
    }

    public static void print(int[] p) {

        for (int i = 0; i < p.length; i++) {
            System.out.print("\t" + i + ":[" + p[i] + "]");
        }
        System.out.print("\n");
    }

}
