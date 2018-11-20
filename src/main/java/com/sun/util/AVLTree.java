package com.sun.util;

/**
 * @author sunhuaquan
 * @Title: AVLTree
 * @ProjectName data-structure
 * @Description: 平衡二叉树
 * @date 2018/11/20 23:16
 */
public class AVLTree<E extends Comparable<E>> implements Tree<E> {

    private Node<E> root;
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(E e) {


    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public E max() {
        return null;
    }

    @Override
    public E min() {
        return null;
    }

    @Override
    public void remove(E e) {

    }

    private class Node<E> {
        private E e;
        private Node<E> left;
        private Node<E> right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        public Node(E e, Node<E> left, Node<E> right) {
            this.e = e;
            this.left = left;
            this.right = right;
        }
    }

}
