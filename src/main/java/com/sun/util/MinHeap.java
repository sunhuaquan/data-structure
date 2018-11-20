package com.sun.util;

public class MinHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MinHeap() {
        data = new ArrayList<>();
    }

    public boolean isEmpty() {
        return data.size() == 0;
    }

    public E front() {

        return data.getFirst();
    }

    /**
     * 将元素e入堆
     *
     * @param e
     */
    public void enqueue(E e) {
        data.addLast(e);
        siftUp(data.size() - 1, e);
    }

    public int parent(int index) {

        if (index == 0) {
            throw new IllegalArgumentException("index is not illegal");
        }
        return (index - 1) / 2;
    }

    public int leftChild(int index) {
        return 2 * index + 1;
    }

    public int rightChild(int index) {
        return 2 * index + 2;
    }

    public void siftUp(int index, E e) {
        while (index > 0 && data.get(parent(index)).compareTo(e) > 0) {
            data.set(index, data.get(parent(index)));
            index = parent(index);
        }
        data.set(index, e);
    }

    /**
     * 取出对顶元素
     *
     * @return
     */
    public E dequeue() {
        E front = data.getFirst();
        E e = data.removeLast();
        siftDown(0, e);
        return front;
    }

    public void siftDown(int index, E e) {
        if (data.isEmpty()) {
            return;
        }
        while (leftChild(index) < data.size()) {
            int j = leftChild(index);
            if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) < 0) {
                j++;
            }
            if (e.compareTo(data.get(j)) < 0)
                break;
            data.set(index, data.get(j));
            index = j;
        }
        data.set(index, e);
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e) {
        E ret = front();
        data.set(0, e);
        siftDown(0, e);
        return ret;
    }
}
