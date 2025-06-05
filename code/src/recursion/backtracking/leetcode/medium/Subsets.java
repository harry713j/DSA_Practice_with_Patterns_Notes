package recursion.backtracking.leetcode.medium;

import java.util.*;

// https://leetcode.com/problems/subsets/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        // Power Set
        int n = nums.length;
        int subsets = 1 << n; // 2^n

        List<List<Integer>> ans = new ArrayList<>();

        for (int num = 0; num < subsets; num++) {
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                if ((num & (1 << i)) != 0){
                    list.add(nums[i]);
                }
            }
            ans.add(list);
        }

        return ans;
        // time: O(n * 2^n)
        // space: O(n * 2^n)
    }

    public List<List<Integer>> subsetsTwo(int[] nums) {
        // using back-tracking
        List<List<Integer>> ans = new ArrayList<>();
        subsetsTwoHelper(nums, ans, new ArrayList<>(), 0);

        return ans;
        // time: O(2^n)
        // space: O(n)
    }

    private void subsetsTwoHelper(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
        if (index >= nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        // take the element
        list.add(nums[index]);
        subsetsTwoHelper(nums, ans, list, index + 1);


        // do not take the element
        list.remove(list.size() - 1);
        subsetsTwoHelper(nums, ans, list, index + 1);
    }

}
