package com.sun.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-10-18 13:43
 */
public class LinkedList<E> implements List<E> {


    private Node<E> dummyNode;

    private int size;

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    private class Node<E> {

        public Node() {

        }

        public Node(E e) {
            this.e = e;
        }

        public Node(E e, Node<E> node) {
            this.e = e;
            this.next = node;
        }

        private E e;
        private Node<E> next;
    }

    public LinkedList() {

        dummyNode = new Node<E>();
        size = 0;
    }

    public void add(E e) {
        Node<E> node = dummyNode;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new Node<E>(e);
        size++;
    }

    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("index is illegal");
        Node<E> node = dummyNode;
        int i = 0;
        while (i < index) {
            node = node.next;
            i++;
        }
        Node<E> newNode = new Node<E>(e);
        newNode.next = node.next;
        node.next = newNode;
        size++;
    }

    public boolean addAll(Collection<? extends E> collection) {

        Iterator<? extends E> iterator = collection.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return true;
    }

    public boolean contains(E e) {
        Node<E> node = dummyNode.next;
        while (node != null) {
            if (node.e.equals(e)) {
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public E get(int index) {
        if (index < 0 || index > size - 1)
            throw new IllegalArgumentException("index is illegal");
        int i = 0;
        Node<E> node = dummyNode.next;
        while (i < index) {
            node = node.next;
            i++;
        }
        return node.e;
    }

    public boolean isEmpty() {
        return size > 0;
    }

    public E remove(int index) {
        if (index < 0 || index > size - 1)
            throw new IllegalArgumentException("index is illegal");

        Node<E> prvNode = dummyNode;
        int i = 0;
        while (i < index) {
            i++;
            prvNode = prvNode.next;
        }
        Node<E> delNode = prvNode.next;
        prvNode.next = prvNode.next.next;
        size--;
        return delNode.e;
    }

    public E set(int index, E e) {
        if (index < 0 || index > size - 1)
            throw new IllegalArgumentException("index is illegal");
        int i = 0;
        Node<E> node = dummyNode.next;
        while (i < index) {
            node = node.next;
            i++;
        }
        E result = node.e;
        node.e = e;
        return result;
    }

    public int size() {
        return size;
    }

    public void addFirst(E e) {

        add(0, e);
    }

    public void addLast(E e) {

        add(size, e);
    }

    public E getFirst() {

        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public int getCapacity() {
        return Integer.MAX_VALUE;
    }

    public int find(E e) {
        return 0;
    }

    @Override
    public void removeElement(E e) {


    }

    @Override
    public String toString() {
        Node<E> node = dummyNode.next;
        StringBuilder sb = new StringBuilder();
        sb.append("LinkedList:");
        while (node != null) {

            sb.append(node.e + "->");
            node = node.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        return sb.toString();
    }
}
