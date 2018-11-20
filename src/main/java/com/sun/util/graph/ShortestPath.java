package com.sun.util.graph;

import com.sun.util.graph.Edge;
import com.sun.util.graph.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description: 广度优先遍历获取无权图的最短路径
 * @author: sunhuaquan
 * @Date: 2018-11-08 17:42
 */
public class ShortestPath {
    private Graph g;
    private int s;
    private boolean[] visited;
    private int[] from;
    private int[] ord;
    private int vertex;

    public ShortestPath(Graph graph, int s) {

        this.g = graph;
        this.vertex = g.getVertexCount();
        visited = new boolean[vertex];
        from = new int[vertex];
        ord = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            visited[i] = false;
            from[i] = -1;
            ord[i] = -1;
        }
        this.s = s;

        Queue<Integer> q = new LinkedList<>();

        // 无向图最短路径算法
        q.add(s);
        visited[s] = true;
        ord[s] = 0;
        while (!q.isEmpty()) {

            int v = q.poll();
            List<Edge> edges = g.getEdges(v);
            for (Edge edge : edges) {
                if (!visited[edge.w()]) {
                    q.add(edge.w());
                    visited[edge.w()] = true;
                    from[edge.w()] = v;
                    ord[edge.w()] = ord[v] + 1;
                }
            }
        }
    }

    public boolean hasPath(int w) {
        if (w < 0 && w >= this.vertex) {
            throw new IllegalArgumentException("w is illegal");
        }
        return visited[w];
    }

    public void path(int w, List<Integer> list) {
        if (w < 0 && w >= this.vertex) {
            throw new IllegalArgumentException("w is illegal");
        }
        Stack<Integer> s = new Stack<>();
        int p = w;
        while (p != -1) {
            s.push(p);
            p = from[p];
        }
        while (!s.empty()) {
            list.add(s.pop());
        }
    }

    public void showPath(int w) {
        if (w < 0 && w >= this.vertex) {
            throw new IllegalArgumentException("w is illegal");
        }
        List<Integer> list = new ArrayList<>();
        path(w, list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print("->");
            }
        }
    }

    public int length(int w) {
        if (w < 0 && w >= this.vertex) {
            throw new IllegalArgumentException("w is illegal");
        }
        return ord[w];
    }
}
