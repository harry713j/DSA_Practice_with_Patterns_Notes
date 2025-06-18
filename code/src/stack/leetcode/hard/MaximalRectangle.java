package stack.leetcode.hard;

import java.util.Stack;

// https://leetcode.com/problems/maximal-rectangle/
public class MaximalRectangle {
    private int largestHistogramArea(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int n = arr.length, maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && arr[stack.peek()] > arr[i]){
                int height = arr[stack.pop()];
                int nse = i; // next smaller
                int pse = stack.empty() ? -1 : stack.peek(); // previous smaller

                int currentArea = height * (nse - pse - 1); // height * width
                maxArea = Math.max(maxArea, currentArea);
            }

            stack.push(i);
        }

        // if there is still elements in stack
        while (!stack.empty()){
            int height = arr[stack.pop()];
            int nse = n;
            int pse = stack.empty() ? -1 : stack.peek();

            int currentArea = height * (nse - pse - 1);
            maxArea = Math.max(maxArea, currentArea);
        }

        return maxArea;
        // time: O(2 * n)
        // space: O(n)
    }

    public int maximalRectangle(char[][] matrix) {
        // quite similar to Largest Rectangle in Histogram
        int m = matrix.length, n = matrix[0].length;
        int[][] prefixSum = new int[m][n];

        // prefix sum the matrix
        for (int j = 0; j < n; j++) {
            int sum = 0;

            for (int i = 0; i < m; i++) {
                if (matrix[i][j] == '0'){
                    sum = 0;
                } else {
                    sum = sum + (matrix[i][j] - '0');
                }

                prefixSum[i][j] = sum;
            }
        }

        int maxArea = 0;

        // now calculate the histogram's area on each row
        for (int i = 0; i < m; i++) {
            maxArea = Math.max(maxArea, largestHistogramArea(prefixSum[i]));
        }

        return maxArea;
        // time: O(m * n) + O(m * 2n)
        // space: O(m * n) + O(m * n)
    }
}
