package stack.leetcode.hard;

import java.util.Stack;

// https://leetcode.com/problems/largest-rectangle-in-histogram/
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        // from each bar we can find the area , and between those areas we can find max area
        // in order to find the area for each bar we can calculate till height greater or equal to bar's height
        // so we need previous smaller element and next smaller element
        int len = heights.length;
        int[] nse = new int[len]; // will store indexes
        int[] pse = new int[len];
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;

        for (int i = 0; i < len; i++) {
            while (!stack.empty() && stack.peek() >= 0 && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            pse[i] = stack.empty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        for (int i = len - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() < len && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            nse[i] = stack.empty() ? len : stack.peek();

            stack.push(i);
        }

        for (int i = 0; i < len; i++) {
            int area = (nse[i] - pse[i] - 1) * heights[i]; // width * height

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
        // time: O(3 * n)
        // space: O(3 * n)
    }

    public int largestRectangleAreaTwo(int[] heights) {
        // instead of pre-computing the next and previous smaller we can do that on the go
        Stack<Integer> stack = new Stack<>();
        int n = heights.length, maxArea = 0;

        for (int i = 0; i < n; i++) {
            while (!stack.empty() && heights[stack.peek()] > heights[i]){
                int height = heights[stack.pop()];
                int nse = i; // next smaller
                int pse = stack.empty() ? -1 : stack.peek(); // previous smaller

                int currentArea = height * (nse - pse - 1); // height * width
                maxArea = Math.max(maxArea, currentArea);
            }

            stack.push(i);
        }

        // if there is still elements in stack
        while (!stack.empty()){
            int height = heights[stack.pop()];
            int nse = n;
            int pse = stack.empty() ? -1 : stack.peek();

            int currentArea = height * (nse - pse - 1);
            maxArea = Math.max(maxArea, currentArea);
        }

        return maxArea;
        // time: O(2 * n)
        // space: O(n)
    }

    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(new LargestRectangleInHistogram().largestRectangleAreaTwo(heights));
    }
}
