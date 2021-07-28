package com.sun.algorithm;


import com.sun.data.TreeNode;
import com.sun.util.ArrayList;
import com.sun.util.List;

public class Interview55 {


    public static void main(String[] args) {

        TreeNode<Integer> one = new TreeNode<>(1);
        TreeNode<Integer> two = new TreeNode<>(2);
        TreeNode<Integer> three = new TreeNode<>(3);
        TreeNode<Integer> four = new TreeNode<>(4);
        TreeNode<Integer> five = new TreeNode<>(5);
        TreeNode<Integer> six = new TreeNode<>(6);
        TreeNode<Integer> seven = new TreeNode<>(7);

        one.setLeft(two);
        one.setRight(three);

        two.setLeft(four);
        two.setRight(five);

        three.setRight(six);

        five.setLeft(seven);

        int deep = treeDeep(one);
        System.out.println(deep);
    }

    public static int treeDeep(TreeNode<Integer> head) {

        if (head == null) {
            return 0;
        }
        int left = treeDeep(head.getLeft());
        int right = treeDeep(head.getRight());
        return left > right ? left + 1 : right + 1;

    }


}
