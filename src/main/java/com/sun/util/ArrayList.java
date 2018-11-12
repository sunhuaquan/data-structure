package com.sun.util;

import java.util.Collection;
import java.util.Iterator;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-10-18 10:14
 */
public class ArrayList<E> implements List<E> {

    private E[] data;

    private int capacity = 10;

    private int size;

    public ArrayList() {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        data = (E[]) new Object[capacity];
        size = 0;
    }

    public ArrayList(E[] data) {
        this.capacity = data.length;
        this.data = data;
        size = data.length;
    }

    public void add(E e) {
        if (isFull()) {
            resize(capacity * 2);
        }
        data[size] = e;
        size++;
    }

    private boolean isFull() {

        return size + 1 >= capacity;
    }

    private boolean indexIsIllegal(int index) {

        return index >= 0 && index < size;
    }

    private void resize(int newSize) {
        this.capacity = newSize;
        E[] oldData = data;
        data = (E[]) new Object[newSize];
        for (int i = 0; i < size; i++) {
            data[i] = oldData[i];
        }
    }

    public void add(int index, E e) {

        if (index < 0 || index > size)
            throw new IllegalArgumentException("index is illegal");
        if (isFull()) {
            resize(capacity * 2);
        }
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        size++;
        data[index] = e;

    }

    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> iterator = collection.iterator();
        while (iterator.hasNext()) {
            this.add(iterator.next());
        }
        return true;
    }

    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public E get(int index) {
        if (!indexIsIllegal(index))
            throw new IllegalArgumentException("index is illegal");
        return data[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(int index) {
        if (!indexIsIllegal(index))
            throw new IllegalArgumentException("index is illegal");
        E result = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        data[size - 1] = null;
        size--;
        return result;
    }

    public E set(int index, E e) {
        if (!indexIsIllegal(index))
            throw new IllegalArgumentException("index is illegal");
        E result = data[index];
        data[index] = e;
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
        if (isEmpty())
            throw new RuntimeException("ArrayList is empty");
        return get(0);
    }

    public E getLast() {
        if (isEmpty())
            throw new RuntimeException("ArrayList is empty");
        return get(size - 1);
    }

    public E removeFirst() {
        if (isEmpty())
            throw new RuntimeException("ArrayList is empty");
        return remove(0);
    }

    public E removeLast() {
        if (isEmpty())
            throw new RuntimeException("ArrayList is empty");
        return remove(size - 1);
    }

    public int getCapacity() {
        return capacity;
    }

    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void removeElement(E e) {
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ArrayList [");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Iterator<E> iterator() {

        return new Itr();
    }

    private class Itr implements Iterator<E> {

        int curr = 0;

        @Override
        public boolean hasNext() {
            return curr < size;
        }

        @Override
        public E next() {
            return data[curr++];
        }
    }
}
