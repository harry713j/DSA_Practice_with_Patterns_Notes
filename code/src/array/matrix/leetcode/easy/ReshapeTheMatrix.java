package array.matrix.leetcode.easy;

public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;

        if (m * n != r * c){
            return mat;
        }

        int[][] result = new int[r][c];

        int i = 0, j = 0; // two pointer to keep track of results index

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                result[i][j++] = mat[row][col];

                if (j == c){
                    i++; j = 0;
                }
            }
        }

        return result;
        // Time: O(m * n)
        // Space: O(1)
    }

    public int[][] matrixReshape1(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;

        if (m * n != r * c){
            return mat;
        }

        int[][] result = new int[r][c];

        for (int i = 0; i < r * c; i++) {
            result[i / c][i % c] = mat[i / n][i % n];
        }

        return result;
        // Time: O(m * n)
        // Space: O(1)
    }
}
