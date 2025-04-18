package array.matrix.leetcode.easy;

public class MatrixDiagonalSum {
// https://leetcode.com/problems/matrix-diagonal-sum/description/
        public int diagonalSum(int[][] mat) {
            int n = mat.length;

            int sum = 0;
            // main diagonal sum + secondary diagonal sum
            for(int i = 0; i < n; i++){
                if (i != n - i - 1) {
                    sum += mat[i][i] + mat[i][n - i - 1];
                } else {
                    sum += mat[i][i];
                }
            }

            return sum;
        }
}
