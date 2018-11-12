package com.sun.test;

import com.sun.util.BST;
import com.sun.util.List;

import java.util.Random;

public class BSTTest {

    public static void main(String[] args) {

        BST<Integer> myBST = new BST<>();
        int[] arr = new int[]{10, 8, 15, 3, 12, 2, 20, 18, 22};
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            myBST.add(arr[i]);
        }
        List<Integer> list = myBST.preOrder();
        System.out.println(list);

        List<Integer> list1 = myBST.inOrder();
        System.out.println(list1);

        List<Integer> list2 = myBST.postOrder();
        System.out.println(list2);

        List<List<Integer>> lists = myBST.levelOrder();
        System.out.println(lists);


  /*      System.out.println("max=" + myBST.max());

        System.out.println("min=" + myBST.min());*/

   /*     Integer integer = myBST.removeMin();

        Integer integer1 = myBST.removeMax();*/

        boolean contains = myBST.contains(11);
        System.out.println(contains);

        System.out.println(myBST.inOrder());

    }
}
