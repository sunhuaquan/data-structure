package com.sun.util.graph;

import com.sun.util.MinHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-11-15 9:37
 */
public class LazyPrimMST2<T extends Comparable<T>> {

    private boolean[] marked;
    private Graph g;
    private List<Edge> mstEdges;
    private MinHeap<Edge> minHeap;
    private double mstWeight;

    public LazyPrimMST2(Graph g) {

        this.g = g;
        minHeap = new MinHeap<>();
        marked = new boolean[g.getVertexCount()];
        mstEdges = new ArrayList<>();
        mstWeight = 0;
        visit(0);
        while (!minHeap.isEmpty()) {
            //获取堆中最小一条边
            Edge minEdge = minHeap.dequeue();
            //不是横切边
            if (marked[minEdge.w()] == marked[minEdge.v()]) {
                continue;
            }
            mstEdges.add(minEdge);
            if (marked[minEdge.v()]) {
                visit(minEdge.w());
            } else {
                visit(minEdge.v());
            }
        }

        for (Edge edge : mstEdges)
            mstWeight += edge.getWeight();
    }

    private void visit(int v) {
        marked[v] = true;
        List<Edge> edges = g.getEdges(v);
        for (Edge edge : edges)
            minHeap.enqueue(edge);
    }

    public double getMstWeight() {
        return mstWeight;
    }

    public List<Edge> getMstEdges() {
        return new ArrayList<>(mstEdges);
    }
}
