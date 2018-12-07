package com.sun.algorithm;

import java.util.Stack;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-12-05 14:51
 */
public class MinStack {

    Stack<Integer> stackData;
    Stack<Integer> stackMin;

    public MinStack() {

        stackData = new Stack<>();
        stackMin = new Stack<>();
    }

    public int pop() {
        int pop = stackData.pop();
        if (pop == stackMin.peek()) {
            stackMin.pop();
        }
        return pop;
    }

    public int push(int value) {

        Integer push = stackData.push(value);
        if (stackMin.isEmpty()) {
            stackMin.push(value);
        } else if (stackMin.peek() >= value) {
            stackMin.push(value);
        }
        return push;
    }

    public int getMin() {
        return stackMin.peek();
    }

    public boolean isEmpty() {
        return stackData.isEmpty();
    }
}
