package array.matrix.leetcode.easy;

public class DetermineMatrixObtainedByRotation {
    // https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/
    public boolean findRotation(int[][] mat, int[][] target) {
        int n = mat.length;
        int[] count = new int[4]; // we can at max rotate the matrix by 4,
        // so we can keep counter of how many elements are equal by comparing the elements in both the matrix

        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < mat[0].length; col++) {
                if (target[row][col] == mat[row][col]) {
                    count[0]++; // count for 0 or 360 degree
                }
                if (target[row][col] == mat[n - col - 1][row]) {
                    count[1]++; // count for 90 degree
                }
                if (target[row][col] == mat[n - row - 1][n - col - 1]) {
                    count[2]++; // count for 180 degree
                }
                if (target[row][col] == mat[col][n - row - 1]) {
                    count[3]++; // count for 270 degree
                }
            }
        }

        return count[0] == n * n || count[1] == n * n || count[2] == n * n || count[3] == n * n;
        // Time: O(n^2)
        // Space: O(1)
    }
}
