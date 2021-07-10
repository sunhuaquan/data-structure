package com.sun.algorithm;

public class DuplicateNumber {


    public static void main(String[] args){

        int[] num=new int[]{4,2,2,3,4};
        Integer duplicateNumber = getDuplicateNumber(num);
        System.out.println(duplicateNumber);

    }

    public static Integer getDuplicateNumber(int[] num){
        if(num==null){
            return null;
        }
        for (int i=0;i<num.length;i++){
            while (num[i]!=i){
                int curr=num[i];
                if(num[i]==num[curr]){
                    return num[i];
                }
                int temp=num[i];
                num[i]=num[curr];
                num[curr]=temp;
            }
        }
        return null;
    }
}
