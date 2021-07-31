package com.sun.algorithm;


import com.sun.data.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Interview37 {

    public static void main(String[] args) {


        TreeNode<Integer> treeNode1 = new TreeNode<>(1);
        TreeNode<Integer> treeNode2 = new TreeNode<>(2);
        TreeNode<Integer> treeNode3 = new TreeNode<>(3);
        TreeNode<Integer> treeNode4 = new TreeNode<>(4);
        TreeNode<Integer> treeNode5 = new TreeNode<>(5);
        TreeNode<Integer> treeNode6 = new TreeNode<>(6);

        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);

        treeNode2.setLeft(treeNode4);

        treeNode3.setLeft(treeNode5);
        treeNode3.setRight(treeNode6);

        String serialize = serialize(treeNode1);

        System.out.println(serialize);

        TreeNode<Integer> deserialize = deserialize(serialize);

        String[] split = serialize.split(",");
        List<String> list = new ArrayList<>();
        for (int i = 0; i < split.length; i++) {
            list.add(split[i]);
        }
        TreeNode deserialize1 = deserialize(list);

        System.out.println("ok");


    }

    public static String serialize(TreeNode<Integer> treeNode) {

        if (treeNode == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        serialize(treeNode, sb);
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private static void serialize(TreeNode<Integer> treeNode, StringBuilder sb) {

        if (treeNode == null) {
            return;
        }
        sb.append(treeNode.getVal()).append(",");
        if (treeNode.getLeft() != null) {
            serialize(treeNode.getLeft(), sb);
        } else {
            sb.append("$").append(",");
        }
        if (treeNode.getRight() != null) {
            serialize(treeNode.getRight(), sb);
        } else {
            sb.append("$").append(",");
        }
    }

    private static int index = -1;

    private static TreeNode deserialize(String str) {
        //反序列化二叉树则是需要将一个二叉树组成的字符创进行反序列化，然后得到这个
        //字符串表示的二叉树
        index++;
        int length = str.length();
        if (index >= length) {
            return null;
        }
        String[] val = str.split(",");
        TreeNode<Integer> node = null;
        while (!val[index].equals("$")) {
            node = new TreeNode(Integer.valueOf(val[index]));
            node.left = deserialize(str);
            node.right = deserialize(str);
        }
        return node;
    }


    private static TreeNode deserialize(List<String> list) {
        if (list.size() <= 0) {
            return null;
        }
        String str = list.remove(0);
        TreeNode<Integer> node = null;
        if (str.equals("$")) {
            return null;
        }
        while (!str.equals("$")) {
            node = new TreeNode(Integer.valueOf(Integer.valueOf(str)));
            node.left = deserialize(list);
            node.right = deserialize(list);
        }
        return node;
    }

}
