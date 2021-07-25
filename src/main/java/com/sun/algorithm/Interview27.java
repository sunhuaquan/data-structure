package com.sun.algorithm;

import com.sun.data.TreeNode;

public class Interview27 {

    public static void main(String[] args) {

        TreeNode<Integer> eight=new TreeNode<>(8);
        TreeNode<Integer> six=new TreeNode<>(6);
        TreeNode<Integer> ten=new TreeNode<>(10);
        TreeNode<Integer> five=new TreeNode<>(5);
        TreeNode<Integer> seven=new TreeNode<>(7);
        TreeNode<Integer> nine=new TreeNode<>(9);
        TreeNode<Integer> elven=new TreeNode<>(11);

        eight.setLeft(six);
        eight.setRight(ten);

        six.setLeft(five);
        six.setRight(seven);

        ten.setLeft(nine);
        ten.setRight(elven);
         mirrorTree(eight);

        System.out.println("ok");

    }

    public static <E> void mirrorTree(TreeNode<E> treeNode){

        if(treeNode==null){
            return ;
        }
        if(treeNode.getLeft()==null&&treeNode.getRight()==null){
            return;
        }

        TreeNode<E> left = treeNode.getLeft();
        treeNode.setLeft(treeNode.getRight());
        treeNode.setRight(left);

        mirrorTree(treeNode.getLeft());
        mirrorTree(treeNode.getRight());
    }

}
