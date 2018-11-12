package com.sun.util;

/**
 * @Description:
 * @param: params
 * @return: returns
 * @author:
 * @Date: date
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();
}
