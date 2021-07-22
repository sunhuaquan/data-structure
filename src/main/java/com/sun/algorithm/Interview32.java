package com.sun.algorithm;


import com.sun.data.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class Interview32 {

    public static void main(String[] args) {

        TreeNode<Integer> eight=new TreeNode<>(8);

        TreeNode<Integer> six=new TreeNode<>(6);
        TreeNode<Integer> ten=new TreeNode<>(10);
        TreeNode<Integer> five=new TreeNode<>(5);
        TreeNode<Integer> seven=new TreeNode<>(7);
        TreeNode<Integer> nine=new TreeNode<>(9);
        TreeNode<Integer> eleven=new TreeNode<>(11);

        eight.setLeft(six);
        eight.setRight(ten);

        six.setLeft(five);
        six.setRight(seven);

        ten.setLeft(nine);
        ten.setRight(eleven);
        printFromTopToBottom(eight);
    }

    public static  <E> void printFromTopToBottom(TreeNode<E> node){

        if(node==null){
            return;
        }
        Queue<TreeNode> queue =new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            TreeNode peek = queue.poll();
            System.out.println(peek.val);
            TreeNode left = peek.getLeft();
            if(left!=null){
                queue.add(left);
            }
            TreeNode right = peek.getRight();
            if(right!=null){
                queue.add(right);
            }
        }
    }

}
