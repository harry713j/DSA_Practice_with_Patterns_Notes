package array.matrix.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        // we would take four pointer top, bottom, left & right and add the elements to the ans
        List<Integer> ans = new ArrayList<>();
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;

        while (top <= bottom && left <= right){
            // first traverse from left -> right
            for (int i = left; i <= right ; i++) {
                ans.add(matrix[top][i]);
            }
            top++;
            // top -> bottom
            for (int i = top; i <= bottom ; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            // right -> left
            if (top <= bottom) { // for single row
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // bottom -> top
            if (left <= right) { // for single col
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }

        return ans;
        // time: O(m*n)
        // space: O(1)
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {19, 20, 21, 22, 23, 7},
                {18, 29, 30, 31, 24, 8},
                {17, 28, 27, 26, 25, 9},
                {16, 15, 14, 13, 11, 10}
        };

        System.out.println(new SpiralMatrix().spiralOrder(matrix));
    }
}
