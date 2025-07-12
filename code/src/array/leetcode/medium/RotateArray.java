package array.leetcode.medium;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-array/
public class RotateArray {
    public void rotate(int[] nums, int k) {
        // brute-force: shift the elements
        k = k % nums.length;

        for (int i = 0; i < k; i++) {
            int last = nums[nums.length - 1];

            for (int j = nums.length - 1; j > 0; j--) {
                nums[j] = nums[j - 1];
            }

            nums[0] = last;
        }

        // time: O(n ^ 2)
        // space: O(1)
    }

    private void reverse(int[] nums, int start, int end){
        while (start <= end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;

            start++;
            end--;
        }
    }

    public void rotateTwo(int[] nums, int k) {
        // optimal: reverse
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);

        // time: O(n)
        // space: O(1)
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        new RotateArray().rotateTwo(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
