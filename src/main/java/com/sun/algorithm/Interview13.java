package com.sun.algorithm;

public class Interview13 {

    public static void main(String[] args) {


        int sum = sum(35, 38);
        System.out.println(sum);
    }

    public static int moveCount(int[][] matrix, int k) {

        if (matrix == null && k <= 1) {
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[] visited = new boolean[row * col];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        return doMoveCount(matrix, 0, 0, k, visited);
    }

    public static int doMoveCount(int[][] matrix, int row, int col, int k, boolean[] visited) {
        int count = 0;
        if (check(matrix, row, col, k, visited)) {
            visited[row * col + col] = true;
            count = 1 + doMoveCount(matrix, row - 1, col, k, visited)
                    + doMoveCount(matrix, row, col - 1, k, visited)
                    + doMoveCount(matrix, row + 1, col, k, visited)
                    + doMoveCount(matrix, row, col + 1, k, visited);
        }
        return count;
    }

    public static boolean check(int[][] matrix, int row, int col, int k, boolean[] visited) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && sum(row, col) <= k && !visited[row * col + col]) {
            return true;
        }
        return false;
    }


    public static int sum(int n1, int n2) {

        int sum = 0;
        while (n1 > 0) {
            sum = sum + n1 % 10;
            n1 = n1 / 10;
        }
        while (n2 > 0) {
            sum = sum + n2 % 10;
            n2 = n2 / 10;
        }
        return sum;

    }

}
