package com.sun.algorithm;

public class Interview11 {


    public static void main(String[] args) {


        int[] num=new int[]{1,1,1,0,1};
        System.out.println(getMin(num));
    }


    public static int getMin(int[] nums) {

        int p1 = 0;
        int p2 = nums.length - 1;
        while (p2 > p1) {
            if (p2 - p1 == 1) {
                return nums[p2];
            }
            int mid=(p1+p2)/2;
            if(nums[p1]==nums[p2]&&nums[p1]==nums[mid]){
                 return order(nums,p1,p2);
            }
            if(nums[mid]>=nums[p1]){
                p1=mid;
            }else if(nums[mid]<=nums[p2]) {
                p2=mid;
            }
        }
        return -1;
    }

    public static int order(int[] nums,int begin,int end){
        int mid=nums[begin];
        for(int i=begin+1;i<end;i++){
            if(nums[i]<mid){
                return nums[i];
            }
        }
        return mid;
    }
}
