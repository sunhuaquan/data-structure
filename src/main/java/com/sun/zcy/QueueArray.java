package com.sun.zcy;

/**
 * @author sunhuaquan
 * @Title: QueueArray
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/12/723:03
 */
public class QueueArray {

    private final int capacity;
    private int size;
    private int[] data;
    private int head;
    private int tail;

    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.head = 0;
        this.tail = 0;
        data = new int[capacity];
    }

    public void enqueue(int e) {
        if (size == capacity) {
            throw new RuntimeException("queue is full");
        }
        data[tail] = e;
        tail = getNext(tail);
        size++;

    }

    public int dequeue() {
        if (size == 0) {
            throw new RuntimeException("queue is empty");
        }
        size--;
        int result = data[head];
        head = getNext(head);
        return result;
    }

    private int getNext(int index) {
        return index + 1 == capacity ? 0 : index + 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
