package com.sun.util;

/**
 * @author sunhuaquan
 * @Title: UnionFind2
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/11/1721:54
 */
public class UnionFind3 implements UF {

    private int[] parent;
    private int[] pSize;
    private int size;


    public UnionFind3(int size) {

        this.size = size;
        parent = new int[size];
        pSize = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            pSize[i] = 1;
        }
    }

    private int find(int i) {
        while (i != parent[i]) {
            i = parent[i];
        }
        return i;

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int rootQ = find(q);
        int rootP = find(p);
        if (pSize[p] < pSize[q]) {
            parent[rootP] = rootQ;
            pSize[rootQ] += pSize[rootP];
        } else {
            parent[rootQ] = rootP;
            pSize[rootP] += pSize[rootQ];
        }
    }
}
