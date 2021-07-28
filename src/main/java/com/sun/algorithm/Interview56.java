package com.sun.algorithm;


public class Interview56 {


    public static void main(String[] args) {

        int[] numsAppearOnce = findNumsAppearOnce(new int[]{2,4,3,6,3,2,5,5});
        for (int i = 0; i < numsAppearOnce.length; i++) {
            System.out.println(numsAppearOnce[i]);
        }
    }


    public static int[] findNumsAppearOnce(int[] data) {

        if (data == null || data.length == 0) {
            return null;
        }
        int sum = 0;
        for (int i = 0; i < data.length; i++) {
            sum = sum ^ data[i];
        }
        //获取sum的第一位1;
        int one = 1;
        int count = 0;
        while ((sum & one) != 1) {
            sum = sum >> 1;
            count++;
        }
        //将index位按 0和1 分为两组
        int[] result = new int[]{0,0};
        for(int i=0;i< data.length;i++){
            if (((data[i] >> count) & one) == 0) {
                result[0]^=data[i];
            }else {
                result[1]^=data[i];
            }
        }
        return result;
    }
}
