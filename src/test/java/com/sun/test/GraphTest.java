package com.sun.test;

import com.sun.jmx.snmp.internal.SnmpSubSystem;
import com.sun.util.graph.*;

import java.util.List;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-11-08 13:42
 */
public class GraphTest {


    public static void main(String[] ss) {

        String filename = "testG1.txt";
        Graph g1 = new DenseGraph(8, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename);
        g1.show();

        List<Edge> edges = g1.getEdges(0);

        System.out.print("\n");
        System.out.println(edges);

        Component component = new Component(g1);
        List dfs = component.getDfs();
        System.out.println(dfs);

        System.out.println(component.count());

        System.out.println(component.isConnected(0, 1));

        Path path = new Path(g1, 0);

        path.showPath(6);

        System.out.print("\n");

        ShortestPath shortestPath = new ShortestPath(g1, 0);

        shortestPath.showPath(6);


        LazyPrimMST2<Double> mst = new LazyPrimMST2<>(g1);

        System.out.print("\n");
        System.out.println("mst:" + mst.getMstEdges());

        System.out.println("mstweight:" + mst.getMstWeight());

        
        PrimMST primMST=new PrimMST(g1);
        List<Edge> mst1 = primMST.getMst();
        System.out.println("primMST:"+mst1);
        System.out.println("primMST:weight:"+primMST.getMstWeight());

    }
}
