package binarysearch.leetcode.medium;

// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
public class FirstAndLastPositionOfElement {
    // brute-force: as the array is sorted, we can do linear search and find the first occurrence
    // then again do the linear search and find the element and if the next element is not equal to it or
    // the index of it is equal to n-1 then this is the last index
    // or search from the end of the array
    public int[] searchRange(int[] nums, int target) {
        // optimal: apply binary search and find first and last occurrence
        int[] result = {-1 , -1};
        if(nums.length == 0){
            return result;
        }

        int start = 0, end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if(start >= nums.length || nums[start] != target){
            return result;
        }

        result[0] = start;

        end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        result[1] = end;

        return result;
        // time: O(log n)
        // space: O(1)
    }
}
