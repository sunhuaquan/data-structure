package com.sun.util;

/**
 * @author sunhuaquan
 * @Title: UnionFind1
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/11/1721:48
 */
public class UnionFind1 implements UF {

    private int[] data;
    private int size;

    public UnionFind1(int size) {

        data = new int[size];
        this.size = size;
        for (int i = 0; i < size; i++) {
            data[i] = i;
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    private int find(int i) {
        return data[i];
    }

    @Override
    public boolean isConnected(int v, int w) {
        return find(v) == find(w);
    }

    @Override
    public void unionElements(int v, int w) {
        int pv = find(v);
        int pw = find(w);
        for (int i = 0; i < size; i++) {
            if (find(i) == pv) {
                data[i] = pw;
            }
        }
    }
}
