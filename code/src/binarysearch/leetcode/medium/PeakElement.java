package binarysearch.leetcode.medium;

// https://leetcode.com/problems/find-peak-element/
public class PeakElement {
    // intuition: peak element is greater than the previous and next element in the array
    public int findPeakElement(int[] nums) {
        // brute-force: traverse from 1st to n-2 index of array and check
        int peakIndex = -1;
        int n = nums.length;

        if (n == 1){
            return 0;
        }

        for (int i = 0; i < n; i++) {
            if (i == 0 && nums[i] > nums[i + 1]){
                peakIndex = 0;
            } else if (i == n - 1 && nums[i] > nums[i - 1]) {
                peakIndex = n - 1;
            } else if (i != 0 && i != n - 1 && (nums[i] > nums[i - 1] && nums[i] > nums[i + 1])){
                peakIndex = i;
            }
        }

        return peakIndex;
        // time: O(n)
        // space: O(1)
    }

    public int findPeakElementTwo(int[] nums) {
        // optimal: using binary search check that condition
        int n = nums.length;
        if (n == 1) return 0;
        if (nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;

        int s = 1, e = n - 2;

        while (s <= e){
            int m = (s + e) / 2;

            if (nums[m] > nums[m - 1] && nums[m] > nums[m + 1]){
                return m;
            }

            // if the mid+1 element is greater than the mid then the peak is at right
            if (nums[m] < nums[m + 1]){
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return -1;
    }
}
