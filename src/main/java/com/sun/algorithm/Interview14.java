package com.sun.algorithm;

public class Interview14 {

    public static void main(String[] args) {

        int i = maxMul(8);
        System.out.println(i);

    }


    public static int maxMul(int length) {

        if (length < 2) {
            return 0;
        }
        if (length == 2) {
            return 1;
        }
        if (length == 3) {
            return 2;
        }
        int[] max=new int[length+1];
        max[0]=0;
        max[1]=1;
        max[2]=2;
        max[3]=3;
        for (int i=4;i<=length;i++){
            int m=0;
            for (int j=1;j<=i/2;j++){
                int c=max[j]*max[i-j];
                if(c>m){
                    m=c;
                }
                max[i]=m;
            }

        }
        return max[length];
    }

}
