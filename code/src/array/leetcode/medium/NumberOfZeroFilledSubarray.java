package array.leetcode.medium;

// https://leetcode.com/problems/number-of-zero-filled-subarrays/description/
public class NumberOfZeroFilledSubarray {
    // brute-force: generate all the subarray and check all the elements in that sub-array is zero
    public long zeroFilledSubarray(int[] nums) {
        // optimal: count the number of continuous zeros and then apply the formula n(n + 1) / 2
        int total = 0;
        int zeroCount = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                zeroCount = 0;
            }

            total += zeroCount;
        }

        return total;
        // time: O(n)
        // space: O(1)
    }
}
