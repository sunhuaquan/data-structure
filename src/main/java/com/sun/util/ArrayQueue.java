package com.sun.util;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-10-19 14:10
 */
public class ArrayQueue<E> implements Queue<E> {

    private ArrayList<E> data;

    public ArrayQueue() {

        data = new ArrayList<E>();
    }

    @Override
    public int getSize() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        data.addLast(e);
    }

    @Override
    public E dequeue() {
        return data.removeFirst();
    }

    @Override
    public E getFront() {
        return data.getFirst();
    }
}
