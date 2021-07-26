package com.sun.algorithm;


public class Interview39 {


    public static void main(String[] args) {


        int i = overHalfInArray(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2});
        System.out.println(i);

    }

    public static int overHalfInArray(int[] data) {

        int number = data[0];
        int count = 1;
        for (int i = 0; i < data.length; i++) {

            if (count == 0) {
                number = data[i];
                count = 1;
            } else if (number == data[i]) {
                count++;
            } else {
                count--;
            }

        }
        if(count>0){
            return number;
        }
        throw new RuntimeException("number not found");
    }
}
