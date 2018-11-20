package com.sun.util.graph;

import com.sun.util.graph.Edge;
import com.sun.util.graph.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Description:深度优先遍历可以得到一条路径
 * @author: sunhuaquan
 * @Date: 2018-11-08 17:42
 */
public class Path {

    boolean[] visited;
    private int vertex;
    private Graph g;
    private int[] from;
    private int s;
    private List<Integer> list = new ArrayList<Integer>();


    public Path(Graph graph, int s) {

        this.g = graph;
        this.vertex = graph.getVertexCount();
        visited = new boolean[vertex];
        from = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            visited[i] = false;
            from[i] = -1;
        }
        this.s = s;
        // 寻路算法
        dfs(s);
    }


    private void dfs(int v) {

        visited[v] = true;
        list.add(v);
        List<Edge> edges = g.getEdges(v);
        for (Edge edge : edges) {
            if (!visited[edge.w()]) {
                from[edge.w()] = v;
                dfs(edge.w());
            }
        }
    }

    public boolean hasPath(int w) {
        if (w < 0 || w > vertex) {
            throw new IllegalArgumentException("w is illegal");
        }
        return visited[w];
    }

    private void path(int w, List<Integer> list) {

        Stack<Integer> stack = new Stack<>();
        int p = w;
        while (p != -1) {
            stack.push(p);
            p = from[p];
        }
        while (!stack.isEmpty()) {
            list.add(stack.pop());
        }
    }

    public void showPath(int w) {

        List<Integer> list = new ArrayList<>();
        path(w, list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i != list.size() - 1) {
                System.out.print("->");
            }
        }
    }
}
