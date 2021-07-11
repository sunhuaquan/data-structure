package com.sun.util;

import com.sun.data.TreeNode;

public class TreeNodeUtil {

    public static List<Integer> getTreeByPre(TreeNode treeNode){

        List<Integer> result=new ArrayList<>();

        getTreeByPre(result,treeNode);
        return result;
    }

    private static void getTreeByPre(List<Integer> list,TreeNode treeNode){

         while (treeNode==null){
             return;
         }
         list.add(treeNode.getVal());
        getTreeByPre(list,treeNode.getLeft());
        getTreeByPre(list,treeNode.getRight());
    }
}
