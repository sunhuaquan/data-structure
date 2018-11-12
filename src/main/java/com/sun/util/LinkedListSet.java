package com.sun.util;

public class LinkedListSet<E> implements Set<E> {

    private LinkedList<E> myLinkedList;

    public LinkedListSet() {

        myLinkedList = new LinkedList<>();
    }

    @Override
    public void add(E e) {
        if (!myLinkedList.contains(e)) {
            myLinkedList.addFirst(e);
        }
    }

    @Override
    public boolean contains(E e) {
        return myLinkedList.contains(e);
    }

    @Override
    public void remove(E e) {
        myLinkedList.removeElement(e);
    }

    @Override
    public int getSize() {
        return myLinkedList.size();
    }

    @Override
    public boolean isEmpty() {
        return myLinkedList.isEmpty();
    }
}
