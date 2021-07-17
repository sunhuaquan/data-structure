package com.sun.algorithm;

public class Interview12 {

    public static void main(String[] args) {

        char[][] matrix=new char[][]{
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}
        };
        char[] val=new char[]{'a','b','f','b'};
        boolean hasPath = hasPath(matrix, val);
        System.out.println(hasPath);

    }

    static int pathLength = 0;

    public static boolean hasPath(char[][] matrix, char[] val) {
        if (matrix == null || val == null) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[] visited = new boolean[row * col];
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if(doHasPath(matrix,i,j,val,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean doHasPath(char[][] matrix, int row, int col,
                                    char[] val, boolean[] visited) {
        if (pathLength >= val.length) {
            return true;
        }
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean hasPath = false;
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && matrix[row][col] == val[pathLength] && !visited[row * col + col]) {
            pathLength++;
            visited[row * col + col] = true;
            hasPath = doHasPath(matrix, row - 1, col, val, visited) ||
                    doHasPath(matrix, row, col - 1, val, visited) ||
                    doHasPath(matrix, row + 1, col, val, visited) ||
                    doHasPath(matrix, row, col + 1, val, visited);
            if(!hasPath){
                pathLength--;
                visited[row * col + col] = false;
            }
        }
        return hasPath;
    }
}
