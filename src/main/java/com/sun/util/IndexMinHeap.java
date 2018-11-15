package com.sun.util;

import java.lang.reflect.Array;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-11-15 10:08
 */
public class IndexMinHeap<E extends Comparable<E>> {
    private E[] data;//原始数据
    private int[] indexes;//树中对应的索引
    private int[] reverse;//
    private int count;
    private int capacity;

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private void shiftUp(int k) {

        while (k > 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) > 0) {
            swap(indexes, k / 2, k);
            reverse[indexes[k / 2]] = k / 2;
            reverse[indexes[k]] = k;
            k /= 2;
        }
    }

    private void shiftDown(int k) {

        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j]].compareTo(data[indexes[j + 1]]) > 0)
                j += 1;

            if (data[indexes[k]].compareTo(data[indexes[j]]) <= 0)
                break;

            swap(indexes, k, j);
            reverse[indexes[k]] = k;
            reverse[indexes[j]] = j;
            k = j;
        }
    }

    public IndexMinHeap(Class<E> type, int capacity) {

        data = (E[]) Array.newInstance(type, capacity + 1);
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];

        for (int i = 0; i <= capacity; i++)
            reverse[i] = 0;

        count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public void insert(int index, E item) {
        assert (count + 1 <= capacity);
        assert (index + 1 >= 1 && index + 1 <= capacity);
        index += 1;
        data[index] = item;
        indexes[count + 1] = index;
        reverse[index] = count + 1;
        count++;
        shiftUp(count);
    }

    public E extractMin() {
        assert (count > 0);
        E ret = data[indexes[1]];
        swap(indexes, 1, count);
        reverse[indexes[count]] = 0;
        reverse[indexes[1]] = 1;
        count--;
        shiftDown(1);
        return ret;
    }

    int extractMinIndex() {
        assert (count > 0);
        int ret = indexes[1] - 1;
        swap(indexes, 1, count);
        reverse[indexes[count]] = 0;
        reverse[indexes[1]] = 1;
        count--;
        shiftDown(1);
        return ret;
    }

    public E getMin() {
        assert (count > 0);
        return data[indexes[1]];
    }

    public int getMinIndex() {
        assert (count > 0);
        return indexes[1] - 1;
    }

    private boolean contain(int index) {

        return reverse[index + 1] != 0;
    }

    public E getItem(int index) {
        assert (contain(index));
        return data[index + 1];
    }

    void change(int index, E newItem) {

        assert (contain(index));
        index += 1;
        data[index] = newItem;

        shiftUp(reverse[index]);
        shiftDown(reverse[index]);
    }
}
