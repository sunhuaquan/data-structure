package com.sun.leetcode;

public class Leetcode200 {


    boolean[][] visit;
    int count;
    static int[][] direct = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        count = 0;
        visit = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visit[i][j] && grid[i][j] == '1') {
                    visit[i][j] = true;
                    count++;
                    searchLands(grid, i, j);
                }
            }
        }
        return count;
    }

    public void searchLands(char[][] grid, int startX, int startY) {
        for (int i = 0; i < 4; i++) {
            int nextX = startX + direct[i][0];
            int nextY = startY + direct[i][1];
            if (isArray(grid, nextX, nextY) && !visit[nextX][nextY] && grid[nextX][nextY] == '1') {
                visit[nextX][nextY] = true;
                searchLands(grid, nextX, nextY);
            }
        }
    }

    public boolean isArray(char[][] board, int row, int col) {

        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }

    public static void main(String args[]) {
        char[][] b1 = {{'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int i = new Leetcode200().numIslands(b1);
        System.out.println(i);
    }
}
