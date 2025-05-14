package binarysearch.leetcode.medium;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
public class MinimumInRotatedSortedArray {
    // brute-force: traverse through the array and compare the elements and find the minimum
    public int findMin(int[] nums) {
        // optimal: as the array is sorted and rotated we can use modified binary search
        // in binary search we search in a half and eliminate other half
        // here we will check if one half is sorted then we will compare the minimum element of it (i.e. first element)
        // then eliminate that half and check in other half
        int start = 0, end = nums.length - 1;
        int min = Integer.MAX_VALUE; // for minimum element

        while (start <= end){
            int mid = (start + end) / 2;

            // check if left half is sorted or not
           if (nums[start] <= nums[mid]){
               min = Math.min(min, nums[start]);
               // shift the pointers to look in other half
               start = mid + 1;
           } else {
               min = Math.min(min, nums[mid]);
               end = mid - 1;
           }
        }

        return min;
        // time: O(log n)
        // space: O(1)
    }
}
