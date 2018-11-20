package com.sun.util.graph;

import java.util.List;

/**
 * @Description:
 * @author: sunhuaquan
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
     * 获取订单数目
     *
     * @return
     */
    int getVertexCount();

    /**
     * 获取边数量
     *
     * @return
     */
    int getEdgeCount();

    /**
     * 展示自己
     */
    void show();

    /**
     * 获取与顶点v相连的所有边
     *
     * @param v
     * @return
     */
    List<Edge> getEdges(int v);

}
