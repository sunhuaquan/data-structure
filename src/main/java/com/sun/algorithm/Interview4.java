package com.sun.algorithm;

public class Interview4 {

    public static void main(String[] args){


        int[][] a=new int[][]{
                {1,2,8,9},
                {2,4,9,12},
                {4,7,10,13},
                {6,8,11,15}
        };

        boolean num = findNum(a, 20);
        System.out.println(num);
    }

    public static boolean findNum(int[][] num,int value){
        if(num==null){
            return false;
        }
        //行
        int row=0;
        //列
        int col=num[0].length-1;
        while (row<num.length&&col>=0){
           if(num[row][col]==value){
               return true;
           }
           if(num[row][col]>value){
               col--;
           }
           else {
               row++;
           }
        }
        return false;
    }
}
