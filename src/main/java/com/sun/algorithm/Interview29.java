package com.sun.algorithm;


public class Interview29 {

    public static void main(String[] args) {

        int[][] data = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
        };
        printMatrixClockwisely(data);
    }


    public static void printMatrixClockwisely(int[][] data) {


        if (data == null || data.length == 0) {
            return;
        }
        int start = 0;
        int rows = data.length;
        int cols = data[0].length;
        while (cols > start * 2 && rows > start * 2) {
            printMatrixCircle(data, cols, rows, start);
            start++;

        }
    }

    private static void printMatrixCircle(int[][] data, int cols, int rows, int start) {

        int endX = cols - 1 - start;
        int endY = rows - 1 - start;
        //从左到右
        for (int i = start; i <= endX; i++) {
            System.out.print(data[start][i] + " ");
        }
        //从上到下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                System.out.print(data[i][endX] + " ");
            }
        }
        //从右到左
        if (start < endX && start < endY) {

            for (int i = endX - 1; i >= start; i--) {
                System.out.print(data[endY][i] + " ");
            }
        }
        //从下到上
        if (start < endX && start < endY - 1) {

            for (int i = endY - 1; i <= start + 1; i--) {
                System.out.print(data[i][start]);
            }
        }
    }
}
