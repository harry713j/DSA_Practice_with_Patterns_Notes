package bitManipulation.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        // brute-force: generating all of its sub sets by `Backtracking`
        // Todo: I will do this one when i will learn the backtracking
        return new ArrayList<>();
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
