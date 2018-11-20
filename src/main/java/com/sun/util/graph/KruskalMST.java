package com.sun.util.graph;

import com.sun.util.MinHeap;
import com.sun.util.UF;
import com.sun.util.UnionFind4;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunhuaquan
 * @Title: KruskalMST
 * @ProjectName data-structure
 * @Description: Kruskal算法求最小生成树
 * @date 2018/11/189:07
 */
public class KruskalMST {

    private Graph g;
    private UF uf;
    private boolean[] marked;
    private double mstWeight;
    private MinHeap<Edge> minHeap;
    private List<Edge> mst;

    public KruskalMST(Graph g) {

        this.g = g;
        uf = new UnionFind4(g.getVertexCount());
        marked = new boolean[g.getVertexCount()];
        minHeap = new MinHeap<>();
        mst = new ArrayList<>();
        for (int i = 0; i < g.getVertexCount(); i++) {
            List<Edge> edges = g.getEdges(i);
            for (Edge edge : edges) {
                if (edge.v() < edge.w()) {
                    minHeap.enqueue(edge);
                }
            }
        }
        while (!minHeap.isEmpty() && mst.size() < g.getVertexCount() - 1) {
            Edge minEdge = minHeap.dequeue();
            if (uf.isConnected(minEdge.v(), minEdge.w())) {
                continue;
            }
            mst.add(minEdge);
            uf.unionElements(minEdge.v(), minEdge.w());
        }

        for (Edge edge : mst) {
            mstWeight += edge.getWeight();
        }

    }

    public double getMstWeight() {
        return mstWeight;
    }

    public List<Edge> getMst() {
        return new ArrayList<>(mst);
    }
}
