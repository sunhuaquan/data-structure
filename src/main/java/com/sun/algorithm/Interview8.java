package com.sun.algorithm;

import com.sun.data.TreeNode;
import com.sun.util.List;
import com.sun.util.TreeNodeUtil;

public class Interview8 {


    public static void main(String[] args) {

        TreeNode<String> a = new TreeNode("a");
        TreeNode<String> b = new TreeNode("b");
        TreeNode<String> c = new TreeNode("c");
        TreeNode<String> d = new TreeNode("d");
        TreeNode<String> e = new TreeNode("e");
        TreeNode<String> f = new TreeNode("f");
        TreeNode<String> g = new TreeNode("g");
        TreeNode<String> h = new TreeNode("h");
        TreeNode<String> i = new TreeNode("i");

        a.left = b;
        a.right = c;

        b.parent = a;
        b.left = d;
        b.right = e;

        c.parent = a;
        c.left = f;
        c.right = g;

        d.parent = b;

        e.parent = b;
        e.left = h;
        e.right = i;

        f.parent = c;
        g.parent = c;

        h.parent = e;
        i.parent = e;

        TreeNode<String> next = getNext(a, d);
        System.out.println(next.val);

    }


    public static <T> TreeNode<T> getNext(TreeNode<T> tree, TreeNode<T> node) {

        if (node.getRight() != null) {
            TreeNode curr = node.getRight();
            while (curr.getLeft() != null) {
                curr = curr.getLeft();
            }
            return curr;
        } else if (node.getRight() == null) {
            TreeNode curr=node;
            TreeNode parent = node.parent;
            while (parent !=null&&parent.getLeft() != curr) {
                curr=parent;
                parent=parent.parent;
            }
            return parent;
        }
        return null;
    }

}
