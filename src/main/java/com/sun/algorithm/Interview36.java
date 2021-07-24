package com.sun.algorithm;


public class Interview36 {

    public static void main(String[] args) {

        BinaryTreeNode ten = new BinaryTreeNode(10);
        BinaryTreeNode six = new BinaryTreeNode(6);
        BinaryTreeNode fourteen = new BinaryTreeNode(14);
        BinaryTreeNode four = new BinaryTreeNode(4);
        BinaryTreeNode eight = new BinaryTreeNode(8);
        BinaryTreeNode twelve = new BinaryTreeNode(12);
        BinaryTreeNode sixteen = new BinaryTreeNode(16);

        ten.left=six;
        ten.right=fourteen;

        six.left=four;
        six.right=eight;

        fourteen.left=twelve;
        fourteen.right=sixteen;
        BinaryTreeNode convert = convert(ten);

        System.out.println(convert);


    }


    public static BinaryTreeNode convert(BinaryTreeNode pRootOfTree) {
        BinaryTreeNode lastnode=null;
        BinaryTreeNode root=pRootOfTree;
        BinaryTreeNode headNode=printConvert(root,lastnode);
        while(headNode!=null&&headNode.left!=null){
            headNode=headNode.left;
        }
        return headNode;

    }

    //使用递归进行转换
    public static BinaryTreeNode printConvert(BinaryTreeNode root, BinaryTreeNode lastnode) {
        if(root==null){
            return null;
        }
        if(root.left!=null){
            lastnode=printConvert(root.left,lastnode);
        }
        root.left=lastnode;
        if(lastnode!=null){
            lastnode.right=root;
        }
        lastnode=root;
        if(root.right!=null){
            lastnode=printConvert(root.right,lastnode);
        }

        return lastnode;

    }

    //二叉树节点
    static class BinaryTreeNode {
        private int value;
        private BinaryTreeNode left;
        private BinaryTreeNode right;

        public BinaryTreeNode() {
        }

        public BinaryTreeNode(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            StringBuilder sb=new StringBuilder();
            BinaryTreeNode treeNode=this;
            BinaryTreeNode prv=null;
            while (treeNode!=null){
                sb.append(treeNode.value);
                sb.append("->");
                prv=treeNode;
                treeNode=treeNode.right;
            }
            sb.append("\n");
            while (prv!=null){
                sb.append(prv.value);
                sb.append("->");
                prv=prv.left;
            }
            return sb.toString();
        }
    }

}
