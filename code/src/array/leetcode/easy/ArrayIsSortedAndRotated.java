package array.leetcode.easy;

// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/
public class ArrayIsSortedAndRotated {
    /*
    * Note: An array A rotated by x positions results in an array B of the same length
    * imp: such that B[i] == A[(i+x) % A.length] for every valid index i.
    * */

    private boolean isSorted(int[] A){
        for (int i = 1; i < A.length; i++) {
            if (A[i] < A[i - 1]){
                return false;
            }
        }
        return true;
    }

    public boolean check(int[] nums) {
        if (nums.length == 1){
            return true;
        }

        int i = 1, n = nums.length;
        int[] copy = new int[n];

        // move i till the end of the sorted part
        while (i < n && nums[i] >= nums[i - 1]){
            i++;
        }

        if (i == n){
            return true;
        }

        // copy elements
        int j = 0, k = i;
        while (j < n && k < n){
            copy[j] = nums[k];
            j++; k++;
        }

        k = 0;
        while (j < n && k < i + 1){
            copy[j] = nums[k];
            j++; k++;
        }

        return isSorted(copy);
        // Time: O(N)
        // Space: O(N)
    }

    public boolean checkTwo(int[] nums) {
        // we need to count how many times the drop happen(i.e. nums[i] < nums[i - 1})
        // if the drop == 0 then already sorted, if 1 then is rotated once and sorted
        // else not sorted

        int drops = 0, n = nums.length;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[i - 1]){
                drops++;
            }

            if (drops > 1){
                return false;
            }
        }

        if (drops == 0){
            return true;
        }


        return (nums[0] >= nums[n - 1]);// checking if rotation is valid or not
        // Time: O(N)
        // Space: O(1)
    }
}
