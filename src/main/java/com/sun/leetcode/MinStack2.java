package com.sun.leetcode;


import java.util.Stack;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-12-05 15:17
 */
public class MinStack2 {
    Stack<Integer> stackData;
    Stack<Integer> stackMin;

    public MinStack2() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        stackData.push(x);
        if (stackMin.isEmpty()) {
            stackMin.push(x);
        } else if (x <= stackMin.peek()) {
            stackMin.push(x);
        } else {
            stackMin.push(stackMin.peek());
        }
    }

    public void pop() {
        stackData.pop();
        stackMin.pop();

    }

    public int top() {
        return stackData.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }
}
