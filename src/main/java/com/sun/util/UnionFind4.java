package com.sun.util;

/**
 * @author sunhuaquan
 * @Title: UnionFind2
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/11/1721:54
 */
public class UnionFind4 implements UF {

    private int[] parent;
    private int[] rank;
    private int size;


    public UnionFind4(int size) {

        this.size = size;
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    private int find(int i) {
        while (i != parent[i])
            i = parent[i];
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
        if (rank[p] < rank[q]) {
            parent[rootP] = rootQ;
        } else if (rank[p] > rank[q]) {
            parent[rootQ] = rootP;
        } else {
            parent[rootP] = rootQ;
            rank[rootQ] += 1;
        }
    }
}
