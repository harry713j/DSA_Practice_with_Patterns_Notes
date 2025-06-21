package slidingWindow_twoPointers.leetcode.medium;

//  https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaxConsecutiveOnesIII {
    public int longestOnesBrute(int[] nums, int k) {
        // brute-force: produce the sub-arrays and count the number of zeros, if number of zeros exceed k then break
        int maxOne = 0;

        for (int i = 0; i < nums.length; i++) {
            int countZeros = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == 0){
                    countZeros++;
                }

                if (countZeros <= k){
                    maxOne = Math.max(maxOne, j - i + 1);
                } else {
                    break;
                }

            }
        }

        return maxOne;
        // time: O(n^2)
        // space: O(1)
    }

    public int longestOnes(int[] nums, int k) {
        // optimal: Sliding Window approach
        int zeroes = 0, maxConsOne = 0;
        int left = 0, right = 0;

        while (right < nums.length){
            if (nums[right] == 0){
                zeroes++;
            }

            while (zeroes > k){
                if (nums[left] == 0){
                    zeroes--;
                }
                left++;
            }

            int consLen = right - left + 1;
            maxConsOne = Math.max(maxConsOne, consLen);

            right++;
        }

        return maxConsOne;
        // time: O(n)
        // space: O(1)
    }
}
