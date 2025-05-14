package array.leetcode.medium;


// https://leetcode.com/problems/sort-colors/
public class SortColor {

    private void swap(int[] nums, int s, int e){
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }

    public void sortColors(int[] nums) {
        // first put 2's on right place
        int left = 0, right = nums.length - 1;

        while (left <= right){
            if (nums[left] == 2){
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }


        // put 1's to the right place
        left = 0;
        while (left <= right){
            if (nums[left] == 1){
                swap(nums, left, right);
                right--;
            } else {
                left++;
            }
        }
        // Time: O(n)
        // Space: O(1)
    }

    // imp: intuition -> https://takeuforward.org/data-structure/sort-an-array-of-0s-1s-and-2s/
    // This is the dutch flag algorithm: we take 3  pointers (low, mid & high)
    // from 0 to low - 1 index -> 0's elements
    // from low to mid - 1 index -> 1's elements
    // from mid to high index -> unsorted elements
    // from high + 1 to n - 1 index -> 2's elements
    public void sortColorsTwo(int[] nums) {
        // we are assuming here the array is unsorted
        // so the elements between mid and high
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high){
            if (nums[mid] == 0){
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 2){
                swap(nums, mid, high);
                high--;
            } else {
                mid++;
            }
        }
        // time: O(n)
        // space: O(1)
    }
}
