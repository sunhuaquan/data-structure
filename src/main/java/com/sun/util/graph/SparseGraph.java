package com.sun.util.graph;

import com.sun.util.graph.Edge;
import com.sun.util.graph.Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-11-08 10:56
 */
public class SparseGraph implements Graph {

    private int n, m;
    private boolean directed;
    private List<List<Edge>> g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Edge> list = new ArrayList<>();
            g.add(list);

        }
    }

    public void addEdge(int v, int w, double weight) {
        if (v < 0 && v >= n) {
            throw new IllegalArgumentException("v is illegal");
        }
        if (w < 0 && w >= n) {
            throw new IllegalArgumentException("w is illegal");
        }

        g.get(v).add(new Edge(v, w, weight));
        if (v != w && !directed)
            g.get(w).add(new Edge(w, v, weight));
        m++;
    }

    public boolean hasEdge(int v, int w) {
        if (v < 0 && v >= n) {
            throw new IllegalArgumentException("v is illegal");
        }
        if (w < 0 && w >= n) {
            throw new IllegalArgumentException("w is illegal");
        }
        for (int i = 0; i < g.get(v).size(); i++)
            if (g.get(v).get(i).other(v) == w)
                return true;
        return false;
    }

    public int getVertexCount() {
        return n;
    }

    public int getEdgeCount() {
        return m;
    }

    public void show() {
        for (int i = 0; i < g.size(); i++) {
            List<Edge> list = g.get(i);
            for (int j = 0; j < list.size(); j++) {
                if (j < list.size() - 1) {
                    System.out.print(list.get(j) + "->");
                } else {
                    System.out.print(list.get(j));
                }
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
    public List<Edge> getEdges(int v) {
        if (v < 0 && v >= n) {
            throw new IllegalArgumentException("v is illegal");
        }
        List<Edge> list = g.get(v);
        List result = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            result.add(list.get(i));
        }
        return result;
    }
}
