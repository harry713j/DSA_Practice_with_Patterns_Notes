package array.tuf.medium;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    // brute force approach would be to check every sub-array sum


    public int longestSubArrayWithSumK(int[] nums, int k){
        // use a hashmap to store the prefix sum
        // this will only work if the array elements are positive
        Map<Integer, Integer> prefixSum = new HashMap<>();

        int sum = 0;
        int maxLen = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            // if the sum == k then we store the length
            if (sum == k){
                maxLen = Math.max(maxLen, i + 1);
            }
            // or we will check the remaining (sum - k) is existing in hashMap
            int remaining = sum - k;
            if (prefixSum.containsKey(remaining)){
                int len = i - prefixSum.get(remaining);
                maxLen = Math.max(maxLen, len);
            }

            if(!prefixSum.containsKey(sum)){
                prefixSum.put(sum, i);
            }
        }

        return maxLen;
        //Time : O(N)
        //Space : O(N)
    }

    // using two pointer (sliding window)
    public int longestSubArrayWithSumKTwo(int[] nums, int k){
        int left = 0, right = 0;
        int sum = 0, maxLen = 0;

        while (right < nums.length){
            sum += nums[right];

            while (left <= right && sum > k){
                sum = sum - nums[left];
                left++;
            }

            if (sum == k){
                maxLen = Math.max(maxLen, right - left + 1);
            }

            right++;
        }
        return maxLen;
        // Time: O(n)
        //Space: O(1)
    }
}
