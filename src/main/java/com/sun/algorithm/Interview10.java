package com.sun.algorithm;

public class Interview10 {


    public static void main(String[] args) {

        System.out.println(fibonacci(1));

    }

    public static long fibonacci(int n) {

        if (n < 2) return n;

        long one=0;
        long two=1;
        for(int i=2;i<=n;i++){
            long sum=one+two;
            one=two;
            two=sum;
        }
        return two;
    }




}
