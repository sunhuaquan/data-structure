package com.sun.algorithm;


/**
 * @Description:
 * @author: sunhuaquan
 * @Date: 2018-12-06 14:14
 */
public class Main {

    public static void main(String[] args) {

        Main main = new Main();
        int row = 3;
        int col = 3;
        int[][] matrix = new int[row][col];
        int v = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = v++;
            }
        }
        main.matrixPrintByZ(matrix);
    }


    public void matrixPrintByZ(int[][] matrix) {

        boolean isUp = true;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        int curR = 0;
        int curL = 0;
        while (curR <= row && curL <= col) {
            System.out.print(matrix[curR][curL] + " ");
            if (isUp) {
                while (curR >= 0 && curL <= col) {
                    System.out.print("index:" + curR + " " + curL + " ");
                    System.out.print(matrix[curR--][curL++] + " ");
                }
            } else {
                while (curR <= row && curL >= 0) {
                    System.out.print("index:" + curR + " " + curL + " ");
                    System.out.print(matrix[curR++][curL--] + " ");
                }
            }
            curR = curR == row ? row : curR + 1;
            curL = curL == col ? col : curL + 1;
        }
    }


}
