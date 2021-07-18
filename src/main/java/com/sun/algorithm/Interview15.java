package com.sun.algorithm;

public class Interview15 {

    public static void main(String[] args) {

        System.out.println(numberOf1(5));

    }

     public static int numberOf1(int n){

        int count=0;
        int flag=1;
        int time=0;
        while (flag>0){

            if((n&flag)>0){
                count++;
            }
            flag=flag<<1;
            time++;
        }
        System.out.println(time);
        return count;
     }


}
