package com.sun.zcy;

import com.sun.util.Node;

import java.util.Stack;

/**
 * @author sunhuaquan
 * @Title: Zcy
 * @ProjectName data-structure
 * @Description: TODO
 * @date 2018/12/8 9:06
 */
public class Zcy {

    public static void printMatrixZigZag(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = 0;
        int dC = 0;
        int endR = matrix.length - 1;
        int endC = matrix[0].length - 1;
        boolean fromUp = false;
        while (tR != endR + 1) {
            printLevel(matrix, tR, tC, dR, dC, fromUp);
            tR = tC == endC ? tR + 1 : tR;
            tC = tC == endC ? tC : tC + 1;
            dC = dR == endR ? dC + 1 : dC;
            dR = dR == endR ? dR : dR + 1;
            fromUp = !fromUp;
        }
        System.out.println();
    }

    public static void printLevel(int[][] m, int tR, int tC, int dR, int dC,
                                  boolean f) {
        if (f) {
            while (tR != dR + 1) {
                System.out.print(m[tR++][tC--] + " ");
            }
        } else {
            while (dR != tR - 1) {
                System.out.print(m[dR--][dC++] + " ");
            }
        }
    }

    public static boolean findNumInSortedMatrix(int[][] matrix, int value) {

        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        //右上角
        int tR = 0;
        int tC = col;
        while (tR <= row && tC >= 0) {
            if (value == matrix[tR][tC]) {
                return true;
            }
            if (value < matrix[tR][tC]) {
                tC--;
            } else {
                tR++;
            }
        }
        return false;
    }

    public static boolean isPalindromeList(Node<Integer> node) {

        Stack<Integer> stack = new Stack<Integer>();
        Node<Integer> head = node;
        while (head != null) {
            stack.push(head.getValue());
            head = head.getNext();
        }
        head = node;
        while (head != null) {
            if (stack.pop() != head.getValue()) {
                return false;
            }
            head = head.getNext();
        }
        return true;
    }

    public static Node listPartition2(Node<Integer> head, int pivot) {
        Node sH = null; // small head
        Node sT = null; // small tail
        Node eH = null; // equal head
        Node eT = null; // equal tail
        Node bH = null; // big head
        Node bT = null; // big tail
        Node next = null; // save next node
        // every node distributed to three lists
        while (head != null) {
            next = head.getNext();
            if (head.getValue() < pivot) {
                if (sH == null) {
                    sH = head;
                    sT = head;
                } else {
                    sT.setNext(head);
                    sT = head;
                }
            } else if (head.getValue() == pivot) {
                if (eH == null) {
                    eH = head;
                    eT = head;
                } else {
                    eT.setNext(head);
                    eT = head;
                }
            } else {
                if (bH == null) {
                    bH = head;
                    bT = head;
                } else {
                    bT.setNext(head);
                    bT = head;
                }
            }
            head = next;
        }
        // small and equal reconnect
        if (sT != null) {
            sT.setNext(eH);
            eT = eT == null ? sT : eT;
        }
        // all reconnect
        if (eT != null) {
            eT.setNext(bH);
        }
        return sH != null ? sH : eH != null ? eH : bH;
    }
}
