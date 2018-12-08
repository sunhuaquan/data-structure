package com.sun.zcy;

/**
 * @author sunhuaquan
 * @Title: QueueArray
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/12/723:03
 */
public class StackArray {

    private final int capacity;
    private int size;
    private int[] data;
    private int top;

    public StackArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.top = -1;
        data = new int[capacity];
    }

    public int peek() {
        if (size == 0) {
            throw new RuntimeException("StackArray is empty");
        }
        return data[top - 1];
    }


    public void push(int e) {
        if (size == capacity) {
            throw new RuntimeException("StackArray is full");
        }
        size++;
        top++;
        data[top] = e;
    }

    public int pop() {
        if (size == 0) {
            throw new RuntimeException("StackArray is empty");
        }
        size--;
        int result = data[top];
        top--;
        return result;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
