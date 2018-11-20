package com.sun.util;


public class BST<E extends Comparable<E>> implements Tree<E> {

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

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

    private Node add(Node node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 是否包含元素e
     *
     * @param e
     * @return
     */
    @Override
    public boolean contains(E e) {

        return contains(root, e);
    }

    public boolean contains(Node node, E e) {

        if (node == null) {
            return false;
        }
        if (node.e.compareTo(e) == 0) {
            return true;
        }
        if (node.e.compareTo(e) < 0) {
            return contains(node.right, e);
        }
        return contains(node.right, e);

    }

    public List<E> preOrder() {

        List<E> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }


    /**
     * 前序遍历的规则：
     * （1）访问根节点
     * （2）前序遍历左子树
     * （3）前序遍历右子树
     *
     * @param root
     * @param list
     */
    private void preOrder(Node root, List<E> list) {

        if (root == null) {
            return;
        }
        list.add(root.e);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }


    public List<E> inOrder() {

        List<E> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    /**
     * 中序遍历的规则：
     * （1）中序遍历左子树
     * （2）访问根节点
     * （3）中序遍历右子树
     */
    private void inOrder(Node root, List<E> list) {

        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.e);
        inOrder(root.right, list);

    }

    public List<E> postOrder() {

        List<E> list = new ArrayList<>();
        postOrder(root, list);
        return list;
    }

    /**
     * 后序遍历二叉树的规则：
     * （1）后序遍历左子树
     * （2）后序遍历右子树
     * （3）访问根节点
     */
    private void postOrder(Node root, List<E> list) {

        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.e);
    }

    public List<List<E>> levelOrder() {

        List<List<E>> list = new ArrayList<>();
        levelOrder(root, list, 0);
        return list;
    }

    private void levelOrder(Node root, List<List<E>> list, int level) {

        if (root == null) {
            return;
        }
        if (list.size() - 1 < level) {
            list.add(new ArrayList<>());
        }
        list.get(level).add(root.e);
        levelOrder(root.left, list, level + 1);
        levelOrder(root.right, list, level + 1);
    }

    @Override
    public E max() {

        return max(root).e;
    }

    private Node max(Node root) {

        if (root.right == null) {
            return root;
        }
        return max(root.right);
    }

    @Override
    public E min() {

        return min(root).e;
    }

    private Node min(Node root) {

        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    public E removeMin() {

        E min = min();
        root = removeMin(root);
        return min;
    }

    private Node removeMin(Node node) {

        if (node.left == null) {
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax() {

        E max = max();
        root = removeMax(root);
        return max;
    }

    private Node removeMax(Node root) {

        if (root.right == null) {
            size--;
            return root.left;
        }
        root.right = removeMax(root.right);
        return root;
    }

    @Override
    public void remove(E e) {

        root = remove(root, e);
    }

    private Node remove(Node node, E e) {

        if (node == null) {
            return node;
        }
        if (node.e.compareTo(e) > 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (node.e.compareTo(e) < 0) {
            node.right = remove(node.right, e);
            return node;
        } else {//删除当前节点
            if (node.left == null) {
                //左节点为空，直接返回右节点
                return node.right;
            }
            if (node.right == null) {
                //右节点为空，直接返回左节点
                return node.left;
            } else {
                //这两行顺序不来调换
                Node min = min(node.right);
                min.right = removeMin(node.right);
                min.left = node.left;
                node.right = node.left = null;
                return min;
            }
        }


    }

    private class Node {
        private E e;
        private Node left;
        private Node right;

        public Node(E e) {
            this.e = e;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        generateString(root, 0, res);
        return res.toString();
    }

    /**
     * 生成以node为根节点，深度为depth的描述二叉树的字符串
     *
     * @param node
     * @param depth
     * @param res
     */
    private void generateString(Node node, int depth, StringBuilder res) {

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateString(node.left, depth + 1, res);
        generateString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }
}
