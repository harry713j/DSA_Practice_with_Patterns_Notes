package array.leetcode.medium;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    private boolean linearSearch(int[] nums, int element){
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element){
                return true;
            }
        }
        return false;
    }

    public int longestConsecutive(int[] nums) {
        // brute-force: for an element we will do linear search it's next element if return true then increase count
        // else we will check the count is greater than previous longest sequence or not
        int n = nums.length;
        int longest = 1;

        for (int i = 0; i < n; i++) {
            int element = nums[i];
            int count = 1;
            while (linearSearch(nums, element + 1)){
                element += 1;
                count += 1;
            }

            longest = Math.max(count, longest);
        }

        return longest;
        // Time: O(n)
        // Space: O(1)
    }

    public int longestConsecutiveTwo(int[] nums) {
        // sort the array amd then check for sequence
        if (nums.length == 0){
            return 0;
        }
        // sort the array
        Arrays.sort(nums);

        int lastSmaller = Integer.MIN_VALUE;
        int count = 0;
        int longest = 1;

        for (int i = 0; i < nums.length; i++) {
            // if difference is 1 then increase count and update last smaller
            if (nums[i] - 1 == lastSmaller){
                count++;
                lastSmaller = nums[i];
            } else if (nums[i] != lastSmaller){
                count = 1;
                lastSmaller = nums[i];
            }

            longest = Math.max(count, longest);
        }

        return longest;
        // Time: O(nlogn)
        // space: O(1)
    }

    public int longestConsecutiveThree(int[] nums) {
        // if the element is not the first element of the sequence then we are not going to search for the
        // rest of it's sequence
        if (nums.length == 0){
            return 0;
        }

        // we need set for storing the elemnts
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longestSequence = 1;

        for (int num : set) {
            if (!set.contains(num - 1)) {
                int element = num;
                int count = 1;
                while (set.contains(element + 1)) {
                    element += 1;
                    count += 1;
                }

                longestSequence = Math.max(longestSequence, count);
            }
        }

        return longestSequence;
        // Time: O(n)
        // Space: O(n)
    }

    public static void main(String[] args) {
        LongestConsecutiveSequence l = new LongestConsecutiveSequence();
        System.out.println(l.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }
}
