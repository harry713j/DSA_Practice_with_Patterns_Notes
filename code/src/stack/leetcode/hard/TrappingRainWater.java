package stack.leetcode.hard;

import java.util.Stack;

// https://leetcode.com/problems/trapping-rain-water/description/
public class TrappingRainWater {
    public int trap(int[] height) {
        // brute-force: water stored on the height, if we have taller block on both  right and left
        if (height.length < 3){
            return 0;
        }
        int total = 0;

        for (int i = 1; i < height.length - 1; i++) {
            int leftMax = 0;
            int rightMax = 0;

            // Find the maximum height bar on the left of current bar (i)
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            // Find the maximum height bar on the right of current bar (i)
            for (int j = i + 1; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            // Calculate trapped water for current bar
            // Water can be trapped if current bar is lower than both its leftMax and rightMax
            int minOfMaxes = Math.min(leftMax, rightMax);
            if (height[i] < minOfMaxes) {
                total += minOfMaxes - height[i];
            }
        }

        return total;
        // time: O(n^2)
        // space: O(1)
        /**
         * This will result in `Time Limit Exceeded`
         */
    }

    public int trapTwo(int[] height) {
        int n = height.length;
        int total = 0;
        int[] suffixMax = new int[n];

        suffixMax[n - 1] = height[n - 1];
        // to keep max till the index from right
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], height[i]);
        }

        int leftMax = height[0]; // to keep track of max from left

        for (int i = 1; i < height.length; i++) {
            int rightMax = suffixMax[i];

            if (height[i] < leftMax && height[i] < rightMax){
                total += Math.min(leftMax, rightMax) - height[i];
            }

            leftMax = Math.max(leftMax, height[i]);
        }

        return total;
        // time: O(n)
        // space: O(n)
    }

    public int trapThree(int[] height) {
        // two-pointer
        if (height == null || height.length < 3){
            return 0;
        }

        int left = 0, leftMax = 0, right = height.length - 1, rightMax = 0, total = 0;

        while (left <= right){
            if (height[left] <= height[right]){
                if (leftMax > height[left]){
                    total += leftMax - height[left];
                } else {
                    leftMax = height[left];
                }
                left++;
            } else {
                if (rightMax > height[right]){
                    total += rightMax - height[right];
                } else {
                    rightMax = height[right];
                }
                right--;
            }
        }

        return total;
        // time: O(n)
        // space: O(1)
    }

    public int trapFour(int[] height) {
        int totalWater = 0;
        Stack<Integer> stack = new Stack<>(); // Stores indices

        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop(); // Index of the bar that forms the bottom of the current well
                if (stack.isEmpty()) {
                    break; // No left boundary
                }
                int leftBound = stack.peek();
                int trappedHeight = Math.min(height[i], height[leftBound]) - height[top];
                int width = i - leftBound - 1;
                totalWater += trappedHeight * width;
            }
            stack.push(i);
        }
        return totalWater;
        // time: O(n)
        // space: O(n)
    }

    public static void main(String[] args) {
        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new TrappingRainWater().trapTwo(heights));
    }
}
