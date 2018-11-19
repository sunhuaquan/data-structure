package com.sun.test;

import com.sun.util.graph.*;

import java.util.List;

/**
 * @author sunhuaquan
 * @Title: DijkstraTest
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/11/1921:28
 */
public class DijkstraTest {

    public static void main(String[] ss) {

        String filename = "testG3.txt";
        Graph g1 = new SparseGraph(8, true);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        g1.show();


        Dijkstra2 dijkstra = new Dijkstra2(g1, 0);
        for (int i = 1; i < 5; i++) {
            List<Edge> edges = dijkstra.showPath(i);
            System.out.println(i+":"+edges+" weight:"+dijkstra.shortestPathTo(i));
        }

    }
}
