package com.sun.test;

import com.sun.util.*;

/**
 * @author sunhuaquan
 * @Title: UFTest
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/11/1721:56
 */
public class UFTest {

    public static void main(String[] args) {

        UF uf = new UnionFind4(10);

        uf.unionElements(0, 1);
        uf.unionElements(0, 2);

        uf.unionElements(3, 4);
        uf.unionElements(3, 5);

        uf.unionElements(6, 7);
        uf.unionElements(6, 8);


        System.out.println(uf.isConnected(0, 1));
        System.out.println(uf.isConnected(0, 2));
        System.out.println(uf.isConnected(0, 3));
        System.out.println(uf.isConnected(0, 6));

        System.out.println(uf.isConnected(3, 5));

        System.out.println(uf.isConnected(3, 6));

        uf.unionElements(2,4);
        System.out.println(uf.isConnected(0, 5));

        uf.unionElements(0,6);
        System.out.println(uf.isConnected(0, 1));
        System.out.println(uf.isConnected(0, 3));
        System.out.println(uf.isConnected(0, 5));

        System.out.println(uf.isConnected(6, 9));
    }
}
