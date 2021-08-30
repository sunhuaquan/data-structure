package com.sun.algorithm;

public class Interview33 {

    public static void main(String[] args) {
        boolean b = VerifySquenceOfBST(new int[]{5, 7, 6, 9, 11, 10, 8});
        System.out.println(b);
    }

    public static boolean verifySequenceOfBST(int[] sequence) {


        if (sequence == null || sequence.length == 0) {
            return true;
        }
        int length = sequence.length;
        int root = sequence[length - 1];
        int i = 0;
        for (; i < length; i++) {
            if (sequence[i] > root) {
                break;
            }
        }
        int j = i;
        for (; j < length; j++) {
            if (sequence[j] < root) {
                return false;
            }
        }
        //判断左子树
        boolean left = true;
        if (i > 0) {
            int[] leftTree = new int[i];
            for (int index = 0; index < i; i++) {
                leftTree[index] = sequence[index];
            }
            left = verifySequenceOfBST(leftTree);
        }

        //判断右子树
        boolean right = true;
        if (j < length - 1) {
            int[] rightTree = new int[length - i];
            for (int index = j; index < length - i - 1; index++) {
                rightTree[index] = sequence[index];
            }
            right = verifySequenceOfBST(rightTree);
        }
        return left && right;

    }


    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

    public static boolean VerifySquenceOfBST(int[] sequence) {
        int n = sequence.length;
        if (n == 0) {
            // 注意审题, 约定空树不是二叉搜索树
            return false;
        }
        return check(sequence, 0, n - 1);
    }

    public static boolean check(int[] sequence, int l, int r) {
        if (l >= r) {
            // 若当前子树只有一个节点
            return true;
        }
        // 当前子树的根节点
        int root = sequence[r];
        // 划分出右子树
        int j = r - 1;
        while (j >= l && sequence[j] > root) {
            j--;
        }
        // 检查左子树是不是存在大于根节点的数
        for (int i = l; i <= j; i++) {
            if (sequence[i] > root) {
                return false;
            }
        }
        // 分治法检查左子树和右子树
        return check(sequence, l, j) && check(sequence, j + 1, r - 1);
    }
}
