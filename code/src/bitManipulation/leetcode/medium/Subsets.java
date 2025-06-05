package bitManipulation.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        // brute-force: generating all of its sub sets by `Backtracking`
        List<List<Integer>> ans = new ArrayList<>();
        subsetsHelper(nums, ans, new ArrayList<>(), 0);

        return ans;
        // time: O(2^n)
        // space: O(n)
    }

    private void subsetsHelper(int[] nums, List<List<Integer>> ans, List<Integer> list, int index) {
        if (index >= nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }

        // take the element
        list.add(nums[index]);
        subsetsHelper(nums, ans, list, index + 1);


        // do not take the element
        list.remove(list.size() - 1);
        subsetsHelper(nums, ans, list, index + 1);

        // time: O(2^n)
        // space: O(n)
    }

    public List<List<Integer>> subsetsWithPowerSet(int[] nums) {
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
}
