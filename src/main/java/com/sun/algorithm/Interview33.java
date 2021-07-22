package com.sun.algorithm;

public class Interview33 {

    public static void main(String[] args) {
        boolean b = verifySequenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8});
        System.out.println(b);
    }

    public static boolean verifySequenceOfBST(int[] sequence) {


        if (sequence == null || sequence.length == 0) {
            return true;
        }
        int length = sequence.length;
        int root = sequence[length - 1];
        int i = 0;
        for (; i < length; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j < length; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        //判断左子树
        boolean left=true;
        if(i>0){
            int[] leftTree=new int[i];
            for (int index=0;index<i;i++){
                leftTree[index]=sequence[index];
            }
            left= verifySequenceOfBST(leftTree);
        }

        //判断右子树
        boolean right=true;
        if(j<length-1){
            int[] rightTree=new int[length-i];
            for (int index=j;index<length-i-1;index++){
                rightTree[index]=sequence[index];
            }
            right=verifySequenceOfBST(rightTree);
        }
        return left&&right;

    }
}
