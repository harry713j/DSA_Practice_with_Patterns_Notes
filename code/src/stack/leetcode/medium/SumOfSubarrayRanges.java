package stack.leetcode.medium;

import java.util.Stack;

// https://leetcode.com/problems/sum-of-subarray-ranges/
public class SumOfSubarrayRanges {
    public long subArrayRangesBrute(int[] nums) {
        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            long largest = nums[i], smallest = nums[i];

            for (int j = i + 1; j < nums.length; j++) {
                largest = Math.max(largest, nums[j]);
                smallest = Math.min(smallest, nums[j]);

                sum += (largest - smallest);
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

    private long subarrayMinimumSum(int[] arr) {
        //intuition: we have to figure out, a particular element has contribution to how many sub-arrays
        // e.g: [1, 4, 6, 7, 3, 7, 8, 1], for 3 it is contributing to 12 sub arrays i.e. 3x12 = 36
        // so we need to calculate for each element previous smallest number and next smallest number

        long total = 0;
        int[] nse = nextSmallest(arr); // next smallest indexes
        int[] pse = previousSmallest(arr); // previous smallest element indexes;

        for (int i = 0; i < arr.length; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;

            total = total + ((long) left * right * arr[i]);
        }

        return total;
        // time: O(3 * n)
        // space: O(2 * n)
    }

    private int[] nextLargest(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.empty() && stack.peek() < arr.length && arr[stack.peek()] <= arr[i]){
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

    private int[] previousLargest(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && stack.peek() >= 0 && arr[stack.peek()] < arr[i]){
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

    private long subarrayMaximumSum(int[] arr){
        long total = 0;
        int[] nle = nextLargest(arr); // next largest indexes
        int[] ple = previousLargest(arr); // previous largest indexes

        for (int i = 0; i < arr.length; i++) {
            int left = i - ple[i];
            int right = nle[i] - i;

            total = total + ((long) left * right * arr[i]);
        }

        return total;
    }

    public long subArrayRanges(int[] nums) {
        // total sum of (largest - smallest) of sub array = total sum of largest in sub array - total sum of smallest in sub array
        return subarrayMaximumSum(nums) - subarrayMinimumSum(nums);
        // time: O(10 * n)
        // space: O(10 * n)
    }

    public static void main(String[] args) {
        int[] nums = {4, -2, -3, 4, 1};

        System.out.println(new SumOfSubarrayRanges().subArrayRanges(nums));
    }
}
