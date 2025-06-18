package stack.leetcode.medium;

import java.util.Stack;

// https://leetcode.com/problems/sum-of-subarray-minimums/
public class SumOfSubArrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        // brute-force: generate all the sub-array and sum up the minimums
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            int minElement = Integer.MAX_VALUE;

            for (int j = i; j < arr.length; j++) {
                minElement = Math.min(minElement, arr[j]);

                sum += minElement;
            }
        }

        return sum;
        // time: O(n^2)
        // space: O(1)
    }

    private int[] nextSmallest(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.empty() && stack.peek() < arr.length && arr[stack.peek()] >= arr[i]){
                stack.pop();
            }

            if (!stack.empty()){
                ans[i] = stack.peek();
            } else {
                ans[i] = arr.length;
            }

            stack.push(i);
        }


        return ans;
    }

    private int[] previousSmallest(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {

            while (!stack.empty() && stack.peek() >= 0 && arr[stack.peek()] > arr[i]){
                stack.pop();
            }

            if (!stack.empty()){
                ans[i] = stack.peek();
            } else {
                ans[i] = -1;
            }

            stack.push(i);
        }

        return ans;
    }

    public int sumSubarrayMinsTwo(int[] arr) {
        //intuition: we have to figure out, a particular element has contribution to how many sub-arrays
        // e.g: [1, 4, 6, 7, 3, 7, 8, 1], for 3 it is contributing to 12 sub arrays i.e. 3x12 = 36
        // so we need to calculate for each element previous smallest number and next smallest number

        long total = 0;
        final int MOD = (int) 1E9 + 7;
        int[] nse = nextSmallest(arr); // next smallest indexes
        int[] pse = previousSmallest(arr); // previous smallest element indexes;

        for (int i = 0; i < arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            total = (total + ((long) left * right * arr[i]) % MOD) % MOD;
        }

        return (int) total;
        // time: O(3 * n)
        // space: O(2 * n)
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println(new SumOfSubArrayMinimums().sumSubarrayMinsTwo(arr));
    }
}
