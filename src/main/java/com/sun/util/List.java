package com.sun.util;

import java.util.Collection;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-10-18 10:07
 */
public interface List<E> extends Iterable<E> {

    void add(E e);

    void add(int index, E e);

    boolean addAll(Collection<? extends E> collection);

    boolean contains(E e);

    E get(int index);

    boolean isEmpty();

    E remove(int index);

    E set(int index, E e);

    int size();

    void addFirst(E e);

    void addLast(E e);

    E getFirst();

    E getLast();

    E removeFirst();

    E removeLast();

    int getCapacity();

    int find(E e);

    void removeElement(E e);
}
