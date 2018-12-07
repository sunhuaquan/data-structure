package com.sun.zcy.chapter8;

/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-12-06 15:17
 */
public class One {

    public static void main(String[] args) {

        One one = new One();
        int row=4;
        int col=3;
        int[][] matrix = new int[row][col];
        int v = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = v++;
            }
        }
        one.spiralOrderPrint(matrix);
    }

    public void spiralOrderPrint(int[][] matrix) {
        int tR = 0;
        int tC = 0;
        int dR = matrix.length - 1;
        int dC = matrix[0].length - 1;
        while (tR <= dR && tC <= dC) {
            print(matrix, tR++, tC++, dR--, dC--);
        }
    }

    private void print(int[][] matrix, int tR, int tC, int dR, int dC) {

        //只有一行
        if (tR == dR) {
            for (int i = tC; i <= dC; i++) {
                System.out.print(matrix[tR][i] + " ");
            }
        } else if (tC == dC) {
            for (int i = tR; i <= dR; i++) {
                System.out.print(matrix[i][tC] + " ");
            }
        } else {
            //上行
            for (int i = tC; i < dC; i++) {
                System.out.print(matrix[tR][i] + " ");
            }
            //右列
            for (int i = tR; i < dR; i++) {
                System.out.print(matrix[i][dC] + " ");
            }
            //下行
            for (int i = dC; i > tC; i--) {
                System.out.print(matrix[dR][i] + " ");
            }
            //左列
            for (int i = dR; i > tR; i--) {
                System.out.print(matrix[i][tC] + " ");
            }
        }

    }
}
