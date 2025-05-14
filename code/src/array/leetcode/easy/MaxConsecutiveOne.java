package array.leetcode.easy;

// https://leetcode.com/problems/max-consecutive-ones/
public class MaxConsecutiveOne {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0, maxOne = 0;

        for (int i = 0; i <nums.length ; i++) {
            if (nums[i] == 1){
                count++;
            } else {
                maxOne = Math.max(maxOne, count);
                count = 0;
            }
        }

        maxOne = Math.max(maxOne, count);

        return maxOne;
        // Time: O(N)
        // Space: O(1)
    }
}
