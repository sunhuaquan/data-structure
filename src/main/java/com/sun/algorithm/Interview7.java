package com.sun.algorithm;

import com.sun.data.Node;
import com.sun.data.TreeNode;
import com.sun.util.List;
import com.sun.util.TreeNodeUtil;

public class Interview7 {


    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);

        treeNode1.setLeft(treeNode2);
        treeNode1.setRight(treeNode3);

        treeNode2.setLeft(treeNode4);

        treeNode3.setLeft(treeNode5);
        treeNode3.setRight(treeNode6);

        treeNode4.setRight(treeNode7);

        treeNode6.setLeft(treeNode8);


        int[] preOrder = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] inOrder = new int[]{4, 7, 2, 1, 5, 3, 8, 6};

        TreeNode treeNode = new Solution().buildTree(preOrder, inOrder);

        TreeNode treeNode9 = constructTree(preOrder, inOrder);



        List<Integer> treeByPre = TreeNodeUtil.getTreeByPre(treeNode9);
        System.out.println(treeByPre);

    }

    public static TreeNode constructTree(int[] preOrder, int[] inOrder) {

        return constructTree(preOrder,inOrder,0,inOrder.length-1);
    }

    private static int index=0;

    public static TreeNode constructTree(int[] preOrder, int[] inOrder, int start, int end) {


        if (start > end) return null;
        TreeNode treeNode = new TreeNode(preOrder[index]);
        //在中序遍历中需要左右子树
        int numIndex = findNumIndex(inOrder, start, end, preOrder[index]);
        index++;
        treeNode.setLeft(constructTree(preOrder, inOrder, start, numIndex - 1));
        treeNode.setRight(constructTree(preOrder,  inOrder, numIndex + 1, end));
        return treeNode;
    }

    public static int findNumIndex(int[] num, int start, int end, int val) {
        for (int i = start; i <= end; i++) {
            if (num[i] == val) {
                return i;
            }
        }
        throw new RuntimeException("该数字不存在:"+val);
    }
}
