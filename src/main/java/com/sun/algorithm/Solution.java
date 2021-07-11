package com.sun.algorithm;

import com.sun.data.TreeNode;

public class Solution {

    public int preIndex = 0;
    //查找pre[pri]的位置
    public int find(int[] inorder, int inbegin,int inend,int val){
        for(int i = inbegin;i<=inend;i++){
            if(inorder[i] == val) return i;
        }
        return -1;
    }
    public TreeNode buildTreeChild(int[] preorder, int[] inorder, int inbegin, int inend) {
        if(inbegin>inend) return null;
        TreeNode root = new TreeNode(preorder[preIndex]);
        int index = find(inorder,inbegin,inend,preorder[preIndex]);
        if(index == -1) return null;
        preIndex++;
        root.left = buildTreeChild(preorder,inorder,inbegin,index-1);
        root.right = buildTreeChild(preorder,inorder,index+1,inend);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || inorder == null) return null;
        return buildTreeChild(preorder,inorder,0,inorder.length-1);
    }
}