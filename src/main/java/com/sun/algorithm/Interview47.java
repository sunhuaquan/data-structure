package com.sun.algorithm;


public class Interview47 {

    public static int maxValueOfGifts(int[][] data) {

        if (data == null || data.length == 0) {
            return 0;
        }
        int row = data.length;
        int col = data[0].length;
        int[] maxValue = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int up = 0;
                int left = 0;
                if (i > 0) {
                    up = maxValue[j];
                }
                if (j > 0) {
                    left = maxValue[j - 1];
                }
                maxValue[j] = Math.max(up, left) + data[i][j];
            }
        }
        return maxValue[col - 1];
    }

    public static void main(String[] args) {
        int[][] num = new int[][]{
                {1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}
        };
        System.out.println(Interview47.maxValueOfGifts(num));
    }

}
