package com.sun.algorithm;


import com.sun.data.TreeNode;
import com.sun.util.ArrayList;
import com.sun.util.List;

public class Interview54 {


    public static void main(String[] args) {


        TreeNode<Integer> five = new TreeNode<>(5);
        TreeNode<Integer> three = new TreeNode<>(3);
        TreeNode<Integer> seven = new TreeNode<>(7);
        TreeNode<Integer> two = new TreeNode<>(2);
        TreeNode<Integer> four = new TreeNode<>(4);
        TreeNode<Integer> six = new TreeNode<>(6);
        TreeNode<Integer> eight = new TreeNode<>(8);
        five.setLeft(three);
        five.setRight(seven);

        three.setLeft(two);
        three.setRight(four);

        seven.setLeft(six);
        seven.setRight(eight);

        TreeNode<Integer> result = kthNode(five, 3);
        System.out.println(result.getVal());
    }

    public static TreeNode<Integer> kthNode(TreeNode<Integer> head, int k) {

        List<TreeNode<Integer>> list = new ArrayList<>();
        prvOrder(head, list);
        for (TreeNode<Integer> node:list){
            System.out.print(node.getVal()+" ");
        }
        System.out.print("\n");
        return list.get(k-1);

    }

    public static void prvOrder(TreeNode<Integer> head, List<TreeNode<Integer>> list) {
        if (head != null) {
            prvOrder(head.getLeft(), list);
            list.add(head);
            prvOrder(head.getRight(), list);
        }
    }

}
