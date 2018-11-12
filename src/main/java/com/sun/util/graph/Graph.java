package com.sun.util.graph;

import java.util.List;

/**
 * @Description:
 * @param: params
 * @return: returns
 * @author:
 * @Date: date
 */
public interface Graph {

    /**
     * 添加一条边v-w
     *
     * @param v
     * @param w
     */
    void addEdge(int v, int w, double weight);

    /**
     * v到w是否有边
     *
     * @param v
     * @param w
     * @return
     */
    boolean hasEdge(int v, int w);

    /**
     *
     * @return
     */
    int getVertexCount();

    /**
     * 获取边数量
     * @return
     */
    int getEdgeCount();

    /**
     * 展示自己1
     */
    void show();

    /**
     * 获取v的所有边
     *
     * @param v
     * @return
     */
    List<Edge> getEdges(int v);

}
