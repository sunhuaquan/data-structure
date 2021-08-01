package com.sun.leetcode;

import java.util.Arrays;

public class Leetcode79 {


    boolean[][] visited;
    static int[][] direct = new int[][]{
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        if (word == null || word.length() == 0) {
            return true;
        }
        int row = board.length;
        int col = board[0].length;
        visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (searchWord(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从board的starX,和startY开始寻找word的第index个字母
     *
     * @param board
     * @param startX
     * @param startY
     * @param word
     * @param index
     * @return
     */
    public boolean searchWord(char[][] board, int startX, int startY, String word, int index) {
        if (index == word.length()) {
            return true;
        }
        System.out.println("从"+Arrays.asList(board)+"的("+startX+"+,"+startY+")开始寻找"+word+"的第"+index+"个字母");
        if (isArray(board, startX, startY) && !visited[startX][startY] && board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;
            for (int i = 0; i < 4; i++) {
                int nextX = startX + direct[i][0];
                int nextY = startY + direct[i][1];
                if (searchWord(board, nextX, nextY, word, index + 1)) {
                    return true;
                }
            }
            visited[startX][startY] = false;
        }
        return false;
    }

    public boolean isArray(char[][] board, int row, int col) {

        return row >= 0 && row < board.length && col >= 0 && col < board[0].length;
    }


    public static void main(String[] args) {

        char[][] chars = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };
        boolean exist = new Leetcode79().exist(chars, "ABCCE");


        System.out.println(exist);
    }
}
