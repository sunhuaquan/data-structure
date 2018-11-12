package com.sun.util.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:图的深度优先遍历，可以获取图的连通量，两点是否连通
 * @author: sunhuaquan
 * @Date: 2018-11-08 17:42
 */
public class Component {

    private Graph g;

    private boolean[] visited;

    private List<Integer> list = new ArrayList<Integer>();

    private int count;

    private int[] id;

    private int vertex;

    public Component(Graph g) {
        this.g = g;
        this.vertex = g.getVertexCount();
        visited = new boolean[vertex];
        id = new int[vertex];
        count = 0;
        for (int i = 0; i < vertex; i++) {
            visited[i] = false;
            id[i] = -1;
        }
        for (int i = 0; i < g.getVertexCount(); i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
    }

    private void dfs(int v) {
        visited[v] = true;
        id[v] = count;
        list.add(v);
        List<Edge> edges = g.getEdges(v);
        for (Edge edge : edges) {
            if (!visited[edge.w()]) {
                dfs(edge.w());
            }
        }
    }

    public List getDfs() {
        List<Integer> result = new ArrayList<Integer>();
        for (Integer item : list)
            result.add(item);
        return result;
    }

    public int count() {
        return count;
    }

    public boolean isConnected(int v, int w) {
        if (v < 0 || v >= g.getVertexCount()) {
            throw new IllegalArgumentException("v is illegal");
        }
        if (w < 0 || w >= g.getVertexCount()) {
            throw new IllegalArgumentException("w is illegal");
        }
        return id[v] == id[w];
    }
}
