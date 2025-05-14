package array.matrix.leetcode.medium;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-image/
public class RotateImage {
    public void rotate(int[][] matrix) {
        // Brute-force: create another n x n matrix and put the elements in the result matrix
        // again run the loops and change every element on matrix as result matrix
        int n = matrix.length;
        int[][] dummy = new int[n][n];

        // rotate and copy the element to dummy
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dummy[i][j] = matrix[n - 1 - j][i];
            }
        }
        // copy elements of dummy to matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = dummy[i][j];
            }
        }
        // Time: O(n^2)
        // Space: O(n^2)
    }

    private void reverse(int[] nums){
        int left = 0, right = nums.length - 1;

        while (left <= right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public void rotateTwo(int[][] matrix) {
        // Space Optimized: We can transpose the matrix then we will reverse each row
        int n = matrix.length;
        //transpose of the matrix
        for (int i = 0; i < n; i++) {
            // if we start j from 0 then the in-place transformation of row and col element will back to it's place
            // so we will start j from i
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // reverse every row
        for (int i = 0; i < n; i++) {
            reverse(matrix[i]);
        }
        // Time: O(n^2)
        // Space: O(1)
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        RotateImage r = new RotateImage();
//        r.rotate(matrix);
        r.rotateTwo(matrix);
        for (int[] m : matrix) {
            System.out.println(Arrays.toString(m));
        }
    }
}
