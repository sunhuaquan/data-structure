package com.sun.util.graph;

import com.sun.util.MinHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunhuaquan
 * @Title: LazyPrimMST
 * @Description: LazyPrimMST算法
 * @date 2018/11/1011:44
 */
public class LazyPrimMST<T extends Comparable<T>> {

    private Graph g;

    private MinHeap<Edge> minHeap;

    private boolean[] marked;

    private final List<Edge> list = new ArrayList<>();

    private double mstWeight;

    public LazyPrimMST(Graph g) {
        this.g = g;
        minHeap = new MinHeap<>();
        marked = new boolean[g.getVertexCount()];
        visit(0);
        mstWeight = 0;
        while (!minHeap.isEmpty()) {
            Edge min = minHeap.dequeue();
            if (marked[min.v()] == marked[min.w()]) {//不是横切边
                continue;
            }
            list.add(min);
            if (!marked[min.v()])
                visit(min.v());
            else
                visit(min.w());
        }

        for (Edge edge : list) {
            mstWeight += edge.getWeight();
        }
    }

    private void visit(int v) {
        marked[v] = true;
        List<Edge> edges = g.getEdges(v);
        for (Edge edge : edges) {
            if (!marked[edge.w()])
                minHeap.enqueue(edge);
        }
    }

    public List<Edge> getMinMst() {
        return new ArrayList<>(list);
    }

    public double getMstWeight() {
        return mstWeight;
    }
}
