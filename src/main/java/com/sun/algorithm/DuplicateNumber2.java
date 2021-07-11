package com.sun.algorithm;

public class DuplicateNumber2 {


    public static void main(String[] args){

        int[] num=new int[]{2,3,5,4,3,2,6,7};
        Integer duplicateNumber = getDuplicateNumber(num);
        System.out.println(duplicateNumber);

    }

    public static Integer getDuplicateNumber(int[] num){
        if(num==null){
            return null;
        }
        int start=0;
        int end=num.length-1;
        while (start<=end){
            int mid=((end-start)>>2)+start;
            int count= getCount(num,start,mid);
            if(start==end){
                if(count>1){
                    return start;
                }
            }
            if(count>mid-start+1){
                end=mid;
            }
            else {
                start=mid+1;
            }
        }
        return null;
    }

    public static int getCount(int[] num,int start,int end){
        int count=0;
        for (int i=0;i<num.length;i++){

            if(num[i]>=start&&num[i]<=end){
                count++;
            }
        }
        return count;
    }
}
