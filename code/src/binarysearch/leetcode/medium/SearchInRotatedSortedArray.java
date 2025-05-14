package binarysearch.leetcode.medium;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
    // brute-force: linear-search
    public int search(int[] nums, int target) {
        // optimal : as the array is rotated, there is two halves that are sorted,
        // we have to search in those
        int start = 0, end = nums.length - 1;

        while (start <= end){
            int mid = start + (end - start) / 2;

            if (nums[mid] == target){
                return mid;
            } else if (nums[mid] >= nums[start]) {
                // check in the one sorted half of the array
                if (nums[start] <= target && nums[mid] >= target){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // search in another half of the array
                if (nums[mid] <= target && nums[end] >= target){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
        // time: O(Log n)
        // space: O(1)
    }

    public static void main(String[] args) {
        int[] nums = {9, 11, 12, 14, 17, 21, 23, 1, 2, 3, 4, 5, 6, 7, 8};
        SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
        System.out.println(s.search(nums, 6));
    }
}
