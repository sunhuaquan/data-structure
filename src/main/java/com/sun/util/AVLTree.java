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
        root = add(root, e);
    }

    /**
     * // 对节点y进行向右旋转操作，返回旋转后新的根节点x
     * //        y                              x
     * //       / \                           /   \
     * //      x   T4     向右旋转 (y)        z     y
     * //     / \       - - - - - - - ->    / \   / \
     * //    z   T3                       T1  T2 T3 T4
     * //   / \
     * // T1   T2
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        y.left = x.right;
        x.right = y;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    /**
     * // 对节点y进行向左旋转操作，返回旋转后新的根节点x
     * //    y                             x
     * //  /  \                          /   \
     * // T1   x      向左旋转 (y)       y     z
     * //     / \   - - - - - - - ->   / \   / \
     * //   T2  z                     T1 T2 T3 T4
     * //      / \
     * //     T3 T4
     */
    private Node leftRotate(Node y) {

        Node x = y.right;
        y.right = x.left;
        x.left = y;
        y.height = Math.max(getHeight(y.left), getHeight(y.right)) + 1;
        x.height = Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    private Node<E> makeBalance(Node<E> node) {

        // 计算平衡因子
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {

            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }

    private Node<E> add(Node<E> node, E e) {
        if (node == null) {
            size++;
            return new Node<>(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        // 更新height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        node = makeBalance(node);
        return node;
    }

    @Override
    public boolean contains(E e) {
        return contains(root, e) != null;
    }

    public Node contains(Node<E> node, E e) {
        if (node == null) {
            return null;
        }
        if (e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return node;
        }
    }

    @Override
    public E max() {
        return max(root).e;
    }

    public Node<E> max(Node node) {
        if (node == null) {
            throw new RuntimeException("the node is null");
        }
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }


    @Override
    public E min() {
        return min(root).e;
    }

    public Node<E> min(Node node) {
        if (node == null) {
            throw new RuntimeException("the node is null");
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    @Override
    public void remove(E e) {
        root = remove(root, e);
    }

    private Node remove(Node<E> node, E e) {
        if (node == null) {
            return null;
        }
        Node<E> retNode;
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            retNode = node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            retNode = node;
        } else {
            if (node.left == null) {
                size--;
                retNode = node.right;
                node.right = null;
            } else if (node.right == null) {
                size--;
                retNode = node.left;
                node.left = null;
            } else {
                //左右都不为空的情况
                Node<E> min = min(node.right);
                Node<E> newNode = remove(node, min.e);
                min.right = newNode.right;
                min.left = node.left;
                node.left = node.right = null;
                retNode = min;
            }
        }
        if (retNode == null) {
            return null;
        }
        // 更新height
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        // 平衡维护
        return makeBalance(retNode);
    }

    @Override
    public List<E> inOrder() {
        List<E> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    private void inOrder(Node<E> node, List<E> list) {
        if (node == null) {
            return;
        }
        inOrder(node.left, list);
        list.add(node.e);
        inOrder(node.right, list);
    }

    /**
     * 判断该二叉树是否是一棵二分搜索树
     *
     * @return
     */
    public boolean isBST() {
        List<E> list = inOrder();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    public boolean isBalanced(Node node) {

        if (node == null) {
            return true;
        }

        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    /**
     * 获得节点node的平衡因子
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    private int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private class Node<E> {
        private E e;
        public int height;
        private Node<E> left;
        private Node<E> right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
            height = 1;
        }

        public Node(E e, Node<E> left, Node<E> right) {
            this.e = e;
            this.left = left;
            this.right = right;
            this.height = Math.max(left.height, right.height) + 1;
        }
    }

}
