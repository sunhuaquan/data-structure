package com.sun.util.graph;

import com.sun.util.IndexMinHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunhuaquan
 * @Title: Dijkstra
 * @ProjectName data-structure
 * @Description: Dijkstra算法求最小路径
 * @date 2018/11/19 21:05
 */
public class Dijkstra {

    private Graph g;
    private int s;
    private double[] distTo;//s到每个点的最短距离
    private boolean[] marked;//是否标记过
    private Edge[] from;//从哪里过来的

    public Dijkstra(Graph g, int s) {
        this.g = g;
        this.s = s;
        distTo = new double[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        from = new Edge[g.getVertexCount()];
        IndexMinHeap<Double> ipq = new IndexMinHeap<>(Double.class, g.getVertexCount());

        distTo[s] = 0;//s到自己的路径最短路径为0；
        ipq.insert(s, distTo[s]);
        marked[s] = true;
        while (!ipq.isEmpty()) {
            int v = ipq.extractMinIndex();
            marked[v] = true;
            List<Edge> edges = g.getEdges(v);
            for (Edge edge : edges) {
                int w = edge.other(v);
                if (marked[w]) continue;
                if (from[w] == null || distTo[v] + edge.getWeight() < distTo[w]) {
                    distTo[w] = distTo[v] + edge.getWeight();
                    from[w] = edge;
                    if (ipq.contain(w))
                        ipq.change(w, distTo[w]);
                    else
                        ipq.insert(w, distTo[w]);
                }
            }
        }
    }

    public double shortestPathTo(int w) {
        assert (w >= 0 && w < g.getVertexCount());
        return distTo[w];
    }

    public boolean hasPathTo(int w) {
        assert (w >= 0 && w < g.getVertexCount());
        return marked[w];
    }

    private void shortestPath(int w, List<Edge> list) {
        assert (w >= 0 && w < g.getVertexCount());
        Stack<Edge> s = new Stack<Edge>();
        Edge e = from[w];
        while (e.v() != this.s) {
            s.push(e);
            e = from[e.v()];
        }
        s.push(e);
        while (!s.empty()) {
            e = s.pop();
            list.add(e);
        }
    }

    public void showPath(int w) {
        assert (w >= 0 && w < g.getVertexCount());
        List<Edge> list = new ArrayList<>();
        shortestPath(w, list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i).v() + "->");
            if (i == list.size() - 1)
                System.out.println(list.get(i).w());
        }
    }
}
