package com.sun.util.graph;

import com.sun.util.IndexMinHeap;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunhuaquan
 * @Title: PrimMST
 * @ProjectName data-structure
 * @Description: 优化后的prim算法
 * @date 2018/11/1222:30
 */
public class PrimMST {

    private Graph g;
    private IndexMinHeap<Edge> indexMinHeap;
    private boolean[] marked;
    private Edge[] edgeTo;
    private List<Edge> mst = new ArrayList<>();
    private double mstWeight;

    public PrimMST(Graph g) {
        this.g = g;
        marked = new boolean[g.getVertexCount()];
        edgeTo = new Edge[g.getVertexCount()];
        indexMinHeap = new IndexMinHeap<>(Edge.class, g.getVertexCount());
        visit(0);
        while (!indexMinHeap.isEmpty()) {
            int v = indexMinHeap.extractMinIndex();
            mst.add(edgeTo[v]);
            visit(v);
        }
        for (Edge edge : mst) {
            mstWeight += edge.getWeight();
        }

    }

    private void visit(int v) {
        marked[v] = true;
        List<Edge> edges = g.getEdges(v);
        for (Edge edge : edges) {

            int w = edge.other(v);
            if (marked[w]) {
                continue;
            }
            if (edgeTo[w] == null) {
                edgeTo[w] = edge;
                indexMinHeap.insert(w, edge);
            } else if (edge.getWeight() < edgeTo[w].getWeight()) {
                edgeTo[w] = edge;
                indexMinHeap.change(w, edge);
            }
        }
    }

    public double getMstWeight() {
        return mstWeight;
    }

    public List<Edge> getMst() {

        return new ArrayList<>(mst);
    }
}
