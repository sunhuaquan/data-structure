package com.sun.algorithm;

import com.sun.data.TreeNode;
import com.sun.util.ArrayList;
import com.sun.util.List;

public class Interview34 {

    public static void main(String[] args) {

        TreeNode<Integer> ten = new TreeNode<>(10);
        TreeNode<Integer> five = new TreeNode<>(5);
        TreeNode<Integer> twelve = new TreeNode<>(12);
        TreeNode<Integer> four = new TreeNode<>(4);
        TreeNode<Integer> elven = new TreeNode<>(7);
        ten.setLeft(five);
        ten.setRight(twelve);

        five.setLeft(four);
        five.setRight(elven);
        findPath(ten, 22);
    }

    public static void findPath(TreeNode<Integer> treeNode, int val) {

        if (treeNode == null || val <= 0) {
            return;
        }
        List<Integer> path = new ArrayList<>();
        findPath(treeNode, val, path,0);
    }

    public static void findPath(TreeNode<Integer> treeNode, int val, List<Integer> path,int sum) {

        sum+=treeNode.getVal();
        path.addLast(treeNode.getVal());
        boolean isLeaf=treeNode.getLeft() == null && treeNode.getRight()==null;
        if (isLeaf && sum == val) {
            for(int i:path){
                System.out.print(i+" ");
            }
            System.out.println("");
        }
        if(treeNode.getLeft()!=null){
            findPath(treeNode.getLeft(),val,path,sum);
        }
        if(treeNode.getRight()!=null){
            findPath(treeNode.getRight(),val,path,sum);
        }
        path.removeLast();
    }
}
