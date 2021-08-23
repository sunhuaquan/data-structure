package com.sun.algorithm;

public class Interview51 {


    private int reversePair = 0; // 统计数组中的逆序对

    public int inversePairs(int[] array) {
        if (array == null) { //数组为null返回0
            return 0;
        }
        int len = array.length;

        if (len == 0) { //数组长度为0返回0
            return 0;
        }
        sort(array, 0, len - 1); //进行排序
        return reversePair;
    }

    private void sort(int[] arr, int start, int end) {
        if (start < end) { //利用归并排序的思想
            int mid = (start + end) / 2;
            sort(arr, start, mid);
            sort(arr, mid + 1, end);
            merger(arr, start, mid, mid + 1, end);
        }
    }

    private void merger(int[] arr, int start1, int end1, int start2, int end2) { //归并排序
        int len = end2 - start1 + 1;
        int [] nums = new int[len];
        int k = end2 - start1 + 1;
        int i = end1;
        int j = end2;

        while(i >= start1 && j >= start2){
            if(arr[i] > arr[j]){
                nums[--k] = arr[i--];
                reversePair = reversePair + (j - start2 + 1);
            }else{
                nums[--k] = arr[j--];
            }
        }
        for( ; i >= start1; i--){
            nums[--k] = arr[i];
        }
        for( ; j >= start2; j--){
            nums[--k] = arr[j];
        }
        for(int m =0; m < len; m++){
            arr[start1++] = nums[m];
        }
    }

    public static void main(String[] args) {
        Interview51 main = new Interview51();
        int nums[] = new int[]{7, 5, 6, 4};
        int total = main.inversePairs(nums);
        System.out.println(total);
    }





}
