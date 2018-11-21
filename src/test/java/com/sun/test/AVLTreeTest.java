package com.sun.test;

import com.sun.util.AVLTree;
import com.sun.util.List;
import com.sun.util.Tree;

import java.util.Random;

/**
 * @author sunhuaquan
 * @Title: AVLTreeTest
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/11/2023:49
 */
public class AVLTreeTest {


    public static void main(String[] args) {

        AVLTree<Integer> tree = new AVLTree<>();
        int[] arr = new int[]{10, 8, 15, 3, 12, 2, 20, 18, 22};
        for (int i = 0; i < arr.length; i++) {
            tree.add(arr[i]);
        }
        List<Integer> list1 = tree.inOrder();
        System.out.println(list1);

        System.out.println(tree.min());
        System.out.println(tree.max());
        System.out.println(tree.contains(1000));


        System.out.println("isBST:"+tree.isBST());
        System.out.println("isBalanced:"+tree.isBalanced());

        tree.remove(8);
        list1 = tree.inOrder();
        System.out.println(list1);
        System.out.println("isBST:"+tree.isBST());
        System.out.println("isBalanced:"+tree.isBalanced());
    }
}
