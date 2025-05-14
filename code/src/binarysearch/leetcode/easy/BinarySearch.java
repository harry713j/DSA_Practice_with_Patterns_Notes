package binarysearch.leetcode.easy;

// https://leetcode.com/problems/binary-search/
public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2; // this is for overflow

            if (nums[mid] > target){
                end = mid - 1;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
        //time: O(log n)
        //space: O(1)
    }

    public int searchRecursive(int[] nums, int target){
        int start = 0, end = nums.length - 1;
        return searchRecursiveHelper(nums, target, start, end);
        // time: O(log n)
        // space: O(log n)
    }

    private int searchRecursiveHelper(int[] nums, int target, int start, int end) {
        if (start > end){
            return -1;
        }

        int mid = start + (end - start) / 2;

        if (nums[mid] == target){
            return mid;
        } else if (nums[mid] > target){
            return searchRecursiveHelper(nums, target, start, mid - 1);
        } else {
            return searchRecursiveHelper(nums, target, mid + 1, end);
        }
    }
}
