package com.sun.data;

public class TreeNode<T> {

    public T val;

    public TreeNode<T> left;

    public TreeNode<T> right;

    public TreeNode<T> parent;


    public TreeNode(T val) {
        this.val = val;
    }

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(TreeNode<T> left) {
        this.left = left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public void setRight(TreeNode<T> right) {
        this.right = right;
    }

    /**
     * 前序遍历
     */
    public void printPreNode(){





    }
    /**
     * 中序遍历
     */
    public void printMidNode(){


    }
}
