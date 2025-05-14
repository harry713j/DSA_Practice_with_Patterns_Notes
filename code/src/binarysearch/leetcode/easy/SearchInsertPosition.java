package binarysearch.leetcode.easy;

// https://leetcode.com/problems/search-insert-position/
public class SearchInsertPosition {
    // brute-force: as the array is sorted, we can do the linear search and look for element
    // that is greater than equal to given target(element >= target) that index would be the insert position
    // if no element is found then the n + 1 index is the insert index
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while(start <= end){
            int mid = (start + end) / 2;

            if(nums[mid] == target){
                return mid;
            } else if(nums[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
        // time: O(log n)
        // space: O(1)
    }
}
