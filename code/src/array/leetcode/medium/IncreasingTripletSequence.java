package array.leetcode.medium;

// https://leetcode.com/problems/increasing-triplet-subsequence/
public class IncreasingTripletSequence {
    public boolean increasingTriplet(int[] nums) {
        // brute-force
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] < nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[j] < nums[k]) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;
        // time: O(n^3), TLE
        // space: O(1)
    }

    public boolean increasingTripletTwo(int[] nums) {
        // optimal: intuition is find the lowest number and then second-lowest number, if there exist a number greater than
        // them then return true
        int a = Integer.MAX_VALUE, b = Integer.MAX_VALUE;

        for (int num : nums){
            if (num <= a){
                a = num;
            } else if (num <= b) {
                b = num;
            } else {
                return true;
            }
        }

        return false;
        // time: O(n)
        // space: O(1)
    }
}
