package com.sun.algorithm;


import java.util.Stack;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-12-05 16:00
 */
public class ReverseStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }
        reverse(stack);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static int reverseStack(Stack<Integer> stack) {
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        } else {
            int last = reverseStack(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
         if(stack.isEmpty()){
             return;
         }
         int i=reverseStack(stack);
         reverse(stack);
         stack.push(i);
    }
}
