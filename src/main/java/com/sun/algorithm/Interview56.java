package com.sun.algorithm;


import com.sun.data.TreeNode;

public class Interview56 {


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

        //three.setRight(six);

        five.setLeft(seven);

        boolean isBalanced = isBalanced(one);
        System.out.println(isBalanced);
    }

    public static boolean isBalanced(TreeNode<Integer> head) {

        if (head == null) {
            return true;
        }
        int left = treeDeep(head.getLeft());
        int right = treeDeep(head.getRight());
        int diff = left - right;
        if (diff > 1 || diff < -1) {
            return false;
        }
        return isBalanced(head.getLeft()) && isBalanced(head.getRight());
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
