package array.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/subarray-sum-equals-k/
public class SubarraySumEqualK {
    public int subarraySum(int[] nums, int k) {
        // brute-force: produce every sub-array sum and check if it is equal to k or not

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k){
                    count++;
                }
            }
        }

        return count;
        // time: O(n ^ 2)
        // space: O(1)
    }

    public int subarraySumTwo(int[] nums, int k) {
        // optimal: we will store the prefix sum till the index and how many times the sum occurred (key, value) in a hash map
        // if sum - k element exist in the hash map then increase the count by value assigned to that prefix sum
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int count = 0;
        int preSum = 0;

        prefixSumMap.put(0, 1); // putting zero because at first if prefix sum == k then we will count

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];

            int rem = preSum - k;
            if (prefixSumMap.containsKey(rem)){
                count += prefixSumMap.get(rem);
            }

            // increase the number of occurrence of the prefix sum
            prefixSumMap.put(preSum, prefixSumMap.getOrDefault(preSum, 0) + 1);
        }

        return count;
        // time: O(n)
        // space: O(n)
        // imp: https://takeuforward.org/arrays/count-subarray-sum-equals-k/
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                1, 2, 3, -3, 1, 1, 1, 2, 9, 7, -13
        };
        System.out.println(new SubarraySumEqualK().subarraySum(nums, 3));
        System.out.println(new SubarraySumEqualK().subarraySumTwo(nums, 3));
    }
}
