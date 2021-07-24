package com.sun.algorithm;


public class Interview21 {

    public static void main(String[] args) {

        int[] data=  new int[]{1, 2, 3, 4, 5,4,6,5,3,5,6,8,5,3,5,7,4,2,4,5,111,87,65,4,2,4,6,765,3,1,3,5};
        reorderOddEven(data);
        for (int i=0;i<data.length;i++){
            System.out.println(data[i]);
        }
    }


    public static void reorderOddEven(int[] data) {

        int i = 0;
        int j = data.length - 1;
        while (i < j) {
            //找到前面的偶数
            while ((data[i] & 0x1 )!= 0&&i<j) {
                i++;
            }
            //找到后面的奇数
            while ((data[j] & 0x1) == 0&&j>i) {
                j--;
            }
            if (i >= j) {
                return;
            }
            int temp=data[i];
            data[i]=data[j];
            data[j]=temp;

        }
    }
}
