package array.matrix.leetcode.medium;

// https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeros {
    public void setZeroes(int[][] matrix) {
    // Brute-force: check if an element is zero then will run loop and make its entire row and col to zero
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    // make the row element zero
                    for (int k = 0; k < n; k++) {
                        matrix[i][k] = 0;
                    }
                    // make the col element zero
                    for (int k = 0; k < m; k++) {
                        matrix[k][j] = 0;
                    }
                }
            }
        }
        // time: O(n^3)
        // space: O(1)
    }

    public void setZeroesTwo(int[][] matrix) {
        // optimized approach: take two boolean array and traverse through the matrix
        // if an element is zero then we will make those elements in boolean array true if it is false
        // then we will make those row and col zero which are true
        int m = matrix.length, n = matrix[0].length;
        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // if row element is true then make those row 0
        // if col element is true then make those col 0
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
               if (row[i] || col[j]){
                   matrix[i][j] = 0;
               }
            }
        }

        // Time: O(m*n)
        // Space: O(m + n)
    }

    public void setZeroesThree(int[][] matrix) {
        // store states of each row in the first of that row, and store states of each column in the first of that column.
        // Because the state of row0 and the state of column0 would occupy the same cell, I let it be the state of row0,
        // and use another variable col0 for column0. In the first phase, use matrix elements to set states in a top-down way.
        // In the second phase, use states to set matrix elements in a bottom-up way.
        int m = matrix.length, n = matrix[0].length;
        int col0 = 1; // for col0

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    if (j != 0) {
                        matrix[0][j] = 0;
                    } else {
                        col0 = 0;
                    }
                }
            }
        }
        //  from (1,1) to (n-1, m-1) make the element 0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        // Finally mark the 1st col & then 1st row
        if (matrix[0][0] == 0){
            for (int i = 0; i < n; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col0 == 0){
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        // Time: O(m*n)
        // Space: O(1)
    }
}
