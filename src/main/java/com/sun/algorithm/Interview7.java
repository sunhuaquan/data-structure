package com.sun.algorithm;

import com.sun.data.Node;
import com.sun.data.TreeNode;
import com.sun.util.List;
import com.sun.util.TreeNodeUtil;

public class Interview7 {


    public static void main(String[] args){

        TreeNode treeNode1=new TreeNode(1);
        TreeNode treeNode2=new TreeNode(2);
        TreeNode treeNode3=new TreeNode(3);
        TreeNode treeNode4=new TreeNode(4);
        TreeNode treeNode5=new TreeNode(5);
        TreeNode treeNode6=new TreeNode(6);
        TreeNode treeNode7=new TreeNode(7);
        TreeNode treeNode8=new TreeNode(8);

        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);

        treeNode2.setLeft(treeNode4);

        treeNode3.setLeft(treeNode5);
        treeNode3.setRight(treeNode6);

        treeNode4.setRight(treeNode7);

        treeNode6.setLeft(treeNode8);


        List<Integer> treeByPre = TreeNodeUtil.getTreeByPre(treeNode1);
        System.out.println(treeByPre);

    }

    public static void printListReverse(Node head){


    }
}
