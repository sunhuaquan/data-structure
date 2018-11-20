package com.sun.util;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-10-19 13:49
 */
public class ArrayStack<E> implements Stack<E> {

    public ArrayList<E> data;

    public ArrayStack() {

        data = new ArrayList<E>();
    }

    @Override
    public E peek() {
        return data.getLast();
    }

    @Override
    public E pop() {
        return data.removeLast();
    }

    @Override
    public E push(E item) {
        data.addLast(item);
        return item;
    }

    @Override
    public boolean empty() {
        return data.isEmpty();
    }

    @Override
    public int search(Object o) {

        return -1;
    }
}
