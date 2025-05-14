package binarysearch.tuf.easy;

// https://takeuforward.org/arrays/implement-upper-bound/
public class UpperBound {
    // brute-force: as the array is sorted,
    // we can use linear search and find the element is which is immediate greater than x
    public int findUpperBound(int[] nums, int x){
        // optimal: using binary search
        int s = 0, e = nums.length - 1;

        while (s <= e){
            int m = (s + e) / 2;

            if (nums[m] > x){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        // after the loop terminate s will be pointing to the element greater than x
        return s;
        // time: O(log n)
        // space: O(1)
    }

    public int findUpperBoundRecursive(int[] nums, int x){
        int s = 0, e = nums.length - 1;
        return findUpperBoundRecursiveHelper(nums, x, s, e);
        // time: O(log n)
        // space: O(log n)
    }

    private int findUpperBoundRecursiveHelper(int[] nums, int x, int s, int e) {
        if (s > e) {
            return s;
        }

        int m = s + (e - s) / 2; // for overflow

        if (nums[m] > x) {
            return findUpperBoundRecursiveHelper(nums, x, s, m - 1);
        } else {
            return findUpperBoundRecursiveHelper(nums, x, m + 1, e);
        }
    }
}
