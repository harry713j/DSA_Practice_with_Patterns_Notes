package array.leetcode.medium;

// https://leetcode.com/problems/next-permutation/
public class NextPermutation {
    /*
    * Brute-Force: Find the every permutation of the array and store them, do linear search and get the next permutation
    * Time complexity for that will be O(n*n!)
    * */

    /*Optimal:
    * We can solve it by observing the pattern,
    * so we have to find the permutation which is immediate lexicographically greater than the array
    * we can keep the prefix same and try to arrange the rest of the elements, if the arrangement lexicographically
    * greater than the array then that is the answer
    *
    * 1. Find the break-point where a[i] < a[i+1]
    * 2. From i+1 to n-1 find the smallest element which is greater than a[i] and swap them
    * 3. now from i+1 to n-1 arrange them in increasing order
    * imp: https://takeuforward.org/data-structure/next_permutation-find-next-lexicographically-greater-permutation/*/

    private void swap(int[] nums, int s, int e) {
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }

    private void reverse(int[] nums, int left, int right) {

        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }

    }

    public void nextPermutation(int[] nums) {
        // find the break point index
        int breakPointIndex = -1;
        int n = nums.length;

        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                breakPointIndex = i;
                break;
            }
        }

        // if breakPointIndex = -1 i.e. the array is in lexicographically greater arrangement
        // so we need to make it lexicographically the lowest arrangement
        // breakPointIndex = -1 means array is sorted in descending order
        // we can reverse to make it the lowest order
        if (breakPointIndex == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        // if breakPointIndex != -1 then we found the break point, and we can swap the elements at nums[breakPointIndex]
        // with the smallest number greater than nums[breakPointIndex] between breakPointIndex+1 and n-1;
        for (int i = n - 1; i >= breakPointIndex + 1; i--) {
            if (nums[i] > nums[breakPointIndex]) {
                swap(nums, breakPointIndex, i);
                break;
            }
        }
        // now in order to find the immediate greater lexicographical arrangement than current array arrangement
        // we must reverse the elements between breakPointIndex+1 and n-1;
        reverse(nums, breakPointIndex + 1, n - 1);
        //Time: O(n)
        //Space: O(1)
    }
}
