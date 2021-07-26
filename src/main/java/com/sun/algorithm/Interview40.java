package com.sun.algorithm;


import com.sun.util.List;
import com.sun.util.MaxHeap;



public class Interview40 {


    public static void main(String[] args) {

        int[] leastNumbers = leastNumbers(new int[]{4,5,1,6,2,7,3,8}, 4);
        for (int i=0;i<leastNumbers.length;i++){
            System.out.println(leastNumbers[i]);
        }

    }


    public static int[] leastNumbers(int[] data, int k) {


        if (data == null || data.length <= k) {
            return data;
        }
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        for (int i=0;i<data.length;i++){
            if(maxHeap.size()<k){
                maxHeap.add(data[i]);
            }
            else {
                Integer max = maxHeap.findMax();
                if(max>data[i]){
                    maxHeap.extractMax();
                    maxHeap.add(data[i]);
                }
            }

        }
        List<Integer> data1 = maxHeap.getData();
        int[] result=new int[k];
        for (int i=0;i<data1.size();i++){
            result[i]=data1.get(i);
        }
        return result;

    }


}
