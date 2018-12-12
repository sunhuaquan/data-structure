package com.sun.util;

public class MaxHeap<E extends Comparable<E>> {

    private ArrayList<E> data;

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public MaxHeap(E[] arr) {
        data = new ArrayList<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i, data.get(i));
        }
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {

        return data.size();
    }

    private int parent(int index) {

        if (index == 0) {
            throw new IllegalArgumentException("index 0 have not parent");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    /**
     * 向堆中添加元素e
     *
     * @param e
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.size() - 1, e);
    }

    private void siftUp(int k, E e) {
        while (k > 0 && data.get(parent(k)).compareTo(e) < 0) {
            data.set(k, data.get(parent(k)));
            k = parent(k);
        }
        data.set(k, e);
    }

    /**
     * 获取最大的元素
     *
     * @return
     */
    public E findMax() {
        return data.getFirst();
    }

    /**
     * 取出最大的数据
     *
     * @return
     */
    public E extractMax() {

        E max = findMax();
        E e = data.removeLast();
        siftDown(0, e);
        return max;
    }

    /**
     * @param k
     * @param e
     */
    private void siftDown(int k, E e) {
        if (data.isEmpty()) {
            return;
        }
        //有子节点的情况
        while (leftChild(k) < data.size()) {
            //j等于子节点中最大的
            int j = leftChild(k);
            if (j + 1 < data.size() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = j + 1;
            }
            //比子节点都大直接跳出
            if (e.compareTo(data.get(j)) > 0) {
                break;
            }
            data.set(k, data.get(j));
            k = j;
        }
        data.set(k, e);

    }
}
