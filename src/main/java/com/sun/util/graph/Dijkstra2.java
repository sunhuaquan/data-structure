package com.sun.util.graph;

import com.sun.util.IndexMinHeap;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author sunhuaquan
 * @Title: Dijkstra2
 * @ProjectName data-structure
 * @Description: Dijkstra算法2求最小路径
 * @date 2018/11/1921:50
 */
public class Dijkstra2 {

    private Graph g;
    private int s;
    private double[] distTo;
    private Edge[] from;
    private boolean[] marked;

    public Dijkstra2(Graph g, int s) {

        this.g = g;
        this.s = s;
        distTo = new double[g.getVertexCount()];
        from = new Edge[g.getVertexCount()];
        marked = new boolean[g.getVertexCount()];
        IndexMinHeap<Double> ipq = new IndexMinHeap<>(Double.class, g.getVertexCount());
        distTo[s] = 0;
        from[s] = null;
        ipq.insert(s, distTo[s]);
        while (!ipq.isEmpty()) {
            int v = ipq.extractMinIndex();
            marked[v] = true;
            List<Edge> edges = g.getEdges(v);
            for (Edge edge : edges) {
                int w = edge.other(v);
                if (marked[w]) {
                    continue;
                }
                //没有路径，则当前路径就是最小路径
                if (from[w] == null) {
                    from[w] = edge;
                    distTo[w] = from[w].getWeight() + distTo[v];
                    ipq.insert(w, edge.getWeight());
                } else if (distTo[v] + edge.getWeight() < distTo[w]) {
                    from[w] = edge;
                    distTo[w] = from[w].getWeight() + distTo[v];
                    ipq.change(w, from[w].getWeight() + distTo[v]);
                }
            }
        }
    }

    /**
     * 获取s到w的最短路径
     *
     * @param w
     */
    public List<Edge> showPath(int w) {
        Stack<Edge> stack = new Stack<>();
        while (from[w] != null) {
            stack.push(from[w]);
            w = from[w].other(w);
        }
        List<Edge> edges = new ArrayList<>();
        while (!stack.isEmpty()) {
            edges.add(stack.pop());
        }
        return edges;

    }

    /**
     * 获取s到w的最短路径权值
     *
     * @param w
     * @return
     */
    public double shortestPathTo(int w) {
        return distTo[w];
    }
}
