package com.sun.util;

public interface Merger<E> {

    public E merge(E data1, E data2);

}