package com.sun.util.graph;

/**
 * @author sunhuaquan
 * @Title: Edge
 * @ProjectName test-demo
 * @Description: 图的边对象
 * @date 2018/11/1010:24
 */
public class Edge implements Comparable<Edge> {

    private int a;
    private int b;
    private double weight;

    public Edge(int a, int b, double weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public int v() {
        return a;
    }

    public int w() {
        return b;
    }

    public double getWeight() {
        return weight;
    }

    /**
     * 根据边的一个顶点获取另外一个顶点
     *
     * @param x
     * @return
     */
    public int other(int x) {
        return x == a ? b : a;
    }

    @Override
    public String toString() {
        return a + "," + b + ":" + weight;
    }


    @Override
    public int compareTo(Edge o) {
        if (this.weight > o.weight) {
            return 1;
        }
        if (this.weight == o.weight) {
            return 0;
        }
        return -1;
    }
}
