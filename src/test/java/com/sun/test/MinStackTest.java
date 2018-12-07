package com.sun.test;

import com.sun.algorithm.MinStack;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-12-05 15:06
 */
public class MinStackTest {

    public static void main(String[] args) {


        MinStack minStack = new MinStack();
        minStack.push(3);
        System.out.println(minStack.getMin());
        minStack.push(4);
        System.out.println(minStack.getMin());
        minStack.push(5);
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.getMin());
        minStack.push(2);
        System.out.println(minStack.getMin());
        minStack.push(1);
        System.out.println(minStack.getMin());
        while (!minStack.isEmpty()) {
            System.out.println("min:"+minStack.getMin());
            System.out.println(minStack.pop());

        }
    }
}
