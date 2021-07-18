package com.sun.algorithm;

public class Interview16 {

    public static void main(String[] args) {

        System.out.println(  power(-2,8));

    }


    public static double power(long base,int exponent){

        if(base==0&&exponent<=0){
            return 0;
        }
        if(exponent<=0){
            long result = doPower(base, -exponent);
            return 1.0/result;
        }
        return doPower(base, exponent);
    }

    public static long doPower(long base,int exponent){

         if(exponent==0){
             return 1;
         }
         if (exponent==1){
             return base;
         }
         long result= doPower(base,exponent>>1);
         result*=result;
         if((exponent&1)==1){
             result*=base;
         }
         return result;

    }

}
