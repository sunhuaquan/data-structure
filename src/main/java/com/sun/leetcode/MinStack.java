package com.sun.leetcode;


import java.util.Stack;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-12-05 15:17
 */
public class MinStack {
    Stack<Integer> stackData;
    Stack<Integer> stackMin;
    public MinStack() {
        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public void push(int x) {
        stackData.push(x);
        if (stackMin.isEmpty()) {
            stackMin.push(x);
        } else if (x <= stackMin.peek()) {
            stackMin.push(x);
        }
    }
    public void pop() {
        int pop = stackData.pop();
        if (pop == stackMin.peek()) {
            stackMin.pop();
        }
    }
    public int top() {
        return stackData.peek();
    }
    public int getMin() {
        return stackMin.peek();
    }
}
