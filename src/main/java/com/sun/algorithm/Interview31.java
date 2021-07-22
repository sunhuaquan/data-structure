package com.sun.algorithm;


import java.util.Stack;

public class Interview31 {

    public static void main(String[] args) {


        boolean popOrder = isPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1});
        System.out.println(popOrder);
    }


    public static boolean isPopOrder(int pPush[], int pPop[]){
        if(pPush==null||pPop==null){
            return false;
        }
        if(pPush.length!= pPop.length){
            return false;
        }
        Stack<Integer> stack=new Stack<>();
        int popIndex=0;
        for (int i=0;i<pPush.length;i++){
            stack.push(pPush[i]);
            while (!stack.isEmpty()&&stack.peek()==pPop[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty()&&popIndex==pPop.length;
    }


}
