package com.sun.util;

/**
 * @Description:
 * @param: params
 * @return: returns
 * @author:
 * @Date: date
 */
public interface Stack<E> {

    E peek();

    E pop();

    E push(E item);

    boolean empty();

    int search(Object o);
}
