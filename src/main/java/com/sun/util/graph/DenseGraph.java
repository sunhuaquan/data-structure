package com.sun.util.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-11-08 9:47
 */
public class DenseGraph implements Graph {

    /**
     * 顶点数
     */
    private int n;
    /**
     * 边数
     */
    private int m;
    /**
     * 是否有向
     */
    private boolean directed;
    /**
     * 边集合
     */
    private Edge[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new Edge[n][n];
    }

    @Override
    public void addEdge(int v, int w, double weight) {

        if (v < 0 && v >= n) {
            throw new IllegalArgumentException("v is illegal");
        }
        if (w < 0 && w >= n) {
            throw new IllegalArgumentException("w is illegal");
        }
        if (hasEdge(v, w)) {
            m--;
        }
        g[v][w] = new Edge(v, w, weight);
        if (!directed) {
            g[w][v] = new Edge(w, v, weight);
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        if (v < 0 && v >= n) {
            throw new IllegalArgumentException("v is illegal");
        }
        if (w < 0 && w >= n) {
            throw new IllegalArgumentException("w is illegal");
        }
        return g[v][w] != null;
    }

    @Override
    public int getVertexCount() {
        return n;
    }

    @Override
    public int getEdgeCount() {
        return m;
    }

    @Override
    public void show() {
        for (int i = 0; i < g.length; i++) {
            for (int j = 0; j < g[i].length; j++) {
                System.out.print((g[i][j] == null ? null : g[i][j].getWeight()) + " |");
            }
            System.out.print("\n");
        }
    }

    /**
     * 获取v的所有边
     *
     * @param v
     * @return
     */
    @Override
    public List<Edge> getEdges(int v) {
        if (v < 0 && v >= n) {
            throw new IllegalArgumentException("v is illegal");
        }
        List<Edge> list = new ArrayList<>();
        for (int i = 0; i < g.length; i++) {
            if (g[v][i] != null) {
                list.add(g[v][i]);
            }
        }
        return list;
    }
}
