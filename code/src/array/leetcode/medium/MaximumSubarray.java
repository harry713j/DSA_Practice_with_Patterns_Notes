package array.leetcode.medium;

// https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        // Kadane's algorithm
        int maxSum = nums[0];
        int currSum = 0;

        for(int i = 0; i < nums.length; i++){
            if(currSum < 0){
                currSum = 0;
            }

            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }


    // Imp: https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array/
}
