package com.sun.algorithm;

import com.sun.data.TreeNode;

public class Interview28 {

    public static void main(String[] args) {


        TreeNode<Integer> treeNode1=new TreeNode<>(8);
        TreeNode<Integer> treeNode2=new TreeNode<>(6);
        TreeNode<Integer> treeNode3=new TreeNode<>(6);
        TreeNode<Integer> treeNode4=new TreeNode<>(5);
        TreeNode<Integer> treeNode5=new TreeNode<>(7);
        TreeNode<Integer> treeNode6=new TreeNode<>(7);
        TreeNode<Integer> treeNode7=new TreeNode<>(5);


        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);

        treeNode2.setLeft(treeNode4);
        treeNode2.setRight(treeNode5);

        treeNode3.setLeft(treeNode6);
        treeNode3.setRight(treeNode7);

        boolean symmetrical = isSymmetrical(treeNode1);

        System.out.println(symmetrical);

    }

    public static boolean isSymmetrical(TreeNode<Integer> treeNode) {

        return isSymmetrical(treeNode, treeNode);
    }

    private static boolean isSymmetrical(TreeNode<Integer> treeNode1, TreeNode<Integer> treeNode2) {

        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 == null || treeNode2 == null) {
            return false;
        }
        if (treeNode1.getVal() != treeNode2.getVal()) {
            return false;
        }
        return isSymmetrical(treeNode1.getRight(), treeNode2.getLeft())
                && isSymmetrical(treeNode1.getLeft(), treeNode2.getRight());
    }


}
