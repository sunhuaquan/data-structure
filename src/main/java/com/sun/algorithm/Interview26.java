package com.sun.algorithm;


import com.sun.data.TreeNode;

public class Interview26 {

    public static void main(String[] args) {

        TreeNode<Integer> eight1=new TreeNode<>(8);
        TreeNode<Integer> eight2=new TreeNode<>(8);
        TreeNode<Integer> seven1=new TreeNode<>(7);
        TreeNode<Integer> nine=new TreeNode<>(9);
        TreeNode<Integer> two=new TreeNode<>(2);
        TreeNode<Integer> four=new TreeNode<>(4);
        TreeNode<Integer> seven2=new TreeNode<>(7);

        eight1.setLeft(eight2);
        eight1.setRight(seven1);

        eight2.setLeft(nine);
        eight2.setRight(two);

        two.setLeft(four);
        two.setRight(seven2);

        TreeNode<Integer> treeNode8=new TreeNode<>(8);
        TreeNode<Integer> treeNode9=new TreeNode<>(9);
        TreeNode<Integer> treeNode2=new TreeNode<>(2);

        treeNode8.setLeft(treeNode9);
        treeNode8.setRight(treeNode2);


        boolean b = hasSubTree(eight1, treeNode8);
        System.out.println(b);
    }

    public static boolean hasSubTree(TreeNode<Integer> treeNode1, TreeNode<Integer> treeNode2) {

        boolean result = false;
        if(treeNode1!=null&&treeNode2!=null){

            if(treeNode1.getVal()==treeNode2.getVal()){
                result=doesTree1HaveTrees(treeNode1,treeNode2);
            }
            if(!result){
                result=hasSubTree(treeNode1.getLeft(),treeNode2);
            }
            if(!result){
                result= hasSubTree(treeNode1.getRight(),treeNode2);
            }
        }
        return result;

    }

    private static boolean doesTree1HaveTrees(TreeNode<Integer> treeNode1, TreeNode<Integer> treeNode2) {

        if(treeNode2==null){
            return true;
        }
        if(treeNode1==null){
            return false;
        }
        System.out.println(treeNode1.getVal()+" "+treeNode2.getVal());
        if(treeNode1.getVal()!=treeNode2.getVal()){
            return false;
        }
        return doesTree1HaveTrees(treeNode1.getLeft(),treeNode2.getLeft())
                &&doesTree1HaveTrees(treeNode1.getRight(),treeNode2.getRight());
    }
}
