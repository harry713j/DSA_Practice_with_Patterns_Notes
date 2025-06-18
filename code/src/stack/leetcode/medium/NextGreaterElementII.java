package stack.leetcode.medium;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        // brute-force: Straight forward
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            int k = i + 1;
            for (; k < n + i; k++) {

                if (nums[k % n] > nums[i]) {
                    ans[i] = nums[k % n];
                    break;
                }
            }

            if (k >= n + i) {
                ans[i] = -1;

            }
        }

        return ans;
        // time: O(n^2)
        // space: O(1)
    }

    public int[] nextGreaterElementsTwo(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!stack.empty() && stack.peek() <= nums[i % n]){
                stack.pop();
            }

            if (i < n){
                ans[i] = stack.empty() ? - 1 : stack.peek();
            }

            stack.push(nums[i % n]);
        }

        return ans;
        // time: O(4 * n), traversing 2 times and popping and pushing elements into stack
        // space: O(2 * n) because of stack
    }

    public static void main(String[] args) {
        int[] nums = {100,1,11,1,120,111,123,1,-1,-100};
        System.out.println(Arrays.toString(new NextGreaterElementII().nextGreaterElements(nums)));
    }
}
