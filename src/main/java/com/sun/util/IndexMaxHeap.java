package com.sun.util;

import java.lang.reflect.Array;

/**
 * @author sunhuaquan
 * @Title: IndexMaxHeap
 * @ProjectName data-structure
 * @Description: 索引堆
 * @date 2018/11/1421:49
 */
public class IndexMaxHeap<E extends Comparable<E>> {
    /**
     * 原始数据
     */
    private E[] data;
    /**
     * 树中对应的索引
     */
    private int[] indexes;
    private int[] reverse;
    private int count;
    private int capacity;

    public IndexMaxHeap(Class<E> type, int capacity) {

        data = (E[]) Array.newInstance(type, capacity + 1);
        indexes = new int[capacity + 1];
        reverse = new int[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public void shiftUp(int k) {

        while (k > 1 && data[indexes[k / 2]].compareTo(data[indexes[k]]) < 0) {
            swap(indexes, k / 2, k);
            reverse[indexes[k / 2]] = k / 2;
            reverse[indexes[k]] = k;
            k /= 2;
        }
    }


    public void shiftDown(int k) {

        while (2 * k <= count) {
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j + 1]].compareTo(data[indexes[j]]) > 0) {
                j += 1;
            }
            if (data[indexes[k]].compareTo(data[indexes[j]]) >= 0) {
                break;
            }
            swap(indexes, k, j);
            reverse[indexes[k]] = k;
            reverse[indexes[j]] = j;
            k = j;
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 传入的i对用户而言,是从0索引的
     * @param i
     * @param item
     */
    public void insert(int i, E item) {
        assert (count + 1 <= capacity);
        assert (i + 1 >= 1 && i + 1 <= capacity);
        i += 1;
        data[i] = item;
        indexes[count + 1] = i;
        reverse[i] = count + 1;
        count++;
        shiftUp(count);
    }

    public E extractMax() {
        assert (count > 0);
        E ret = data[indexes[1]];
        swap(indexes, 1, count);
        reverse[indexes[count]] = 0;
        reverse[indexes[1]] = 1;
        count--;
        shiftDown(1);
        return ret;
    }

    public int extractMaxIndex() {
        assert (count > 0);
        int ret = indexes[1] - 1;
        swap(indexes, 1, count);
        reverse[indexes[count]] = 0;
        reverse[indexes[1]] = 1;
        count--;
        shiftDown(1);
        return ret;
    }

    public E getMax() {
        assert (count > 0);
        return data[indexes[1]];
    }

    public int getMaxIndex() {
        assert (count > 0);
        return indexes[1] - 1;
    }

    public boolean contain(int i) {
        assert (i + 1 >= 1 && i + 1 <= capacity);
        return reverse[i + 1] != 0;
    }

    public E getItem(int i) {
        assert (contain(i));
        return data[i + 1];
    }

    public void change(int i, E newItem) {

        assert (contain(i));
        i += 1;
        data[i] = newItem;
        int j = reverse[i];
        shiftUp(j);
        shiftDown(j);
    }
}
