package binarysearch.tuf.easy;

// https://takeuforward.org/data-structure/count-occurrences-in-sorted-array/
public class CountOccurrenceOfElement {
    // brute-force: linear search the element and count the occurrence
    public int countOccurrence(int[] nums, int target){
        // optimal: as array is sorted we can use binary search and get first and last occurrence of the element
        int first = firstOccurrence(nums, target);
        int last = lastOccurrence(nums, target);

        return last - first + 1;
        // time: O(Log n)
        // space: O(1)
    }

    private int lastOccurrence(int[] nums, int target) {
        int s = 0, e = nums.length - 1;

        while (s < e){
            int m = (s + e) / 2;
            if (nums[m] > target){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return s;
    }

    private int firstOccurrence(int[] nums, int target) {
        int s = 0, e = nums.length - 1;

        while (s < e){
            int m = (s + e) / 2;
            if (nums[m] < target){
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        return e;
    }

}
