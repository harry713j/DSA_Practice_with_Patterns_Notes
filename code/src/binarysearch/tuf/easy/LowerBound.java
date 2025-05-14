package binarysearch.tuf.easy;

// https://takeuforward.org/arrays/implement-lower-bound-bs-2/
public class LowerBound {
    //brute-force: linear search and check if array element is greater than equal to x then return the index
    public int findLowerBound(int[] nums, int x){
        // optimal: using binary search
        int s = 0, e = nums.length - 1;

        while (s <= e){
            int m = s + (e - s) / 2;
            if (nums[m] == x){
                return m;
            } else if (nums[m] < x) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        // if not match with any index then start index will be pointing to the higher element than x
        return s;
        // time: O(log n)
        // space: O(1)
    }

    public int findLowerBoundRecursive(int[] nums, int x){
        int s = 0, e = nums.length - 1;
        return findLowerBoundRecursiveHelper(nums, x, s, e);
        // time: O(log n)
        // space: O(log n)
    }

    private int findLowerBoundRecursiveHelper(int[] nums, int x, int s, int e) {
        if (s > e){
            return s;
        }

        int m = (s + e) / 2;

        if (nums[m] == x){
            return m;
        } else if (nums[m] < x) {
            return findLowerBoundRecursiveHelper(nums, x, m + 1, e);
        } else {
            return findLowerBoundRecursiveHelper(nums, x, s, m - 1);
        }
    }

}
