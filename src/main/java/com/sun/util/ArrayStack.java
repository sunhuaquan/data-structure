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

    public E peek() {
        return data.getLast();
    }

    public E pop() {
        return data.removeLast();
    }

    public E push(E item) {
        data.addLast(item);
        return item;
    }

    public boolean empty() {
        return data.isEmpty();
    }

    public int search(Object o) {

        return -1;
    }
}
