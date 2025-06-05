package recursion.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutations/
public class PermutationOfArray {
    public List<List<Integer>> permute(int[] nums) {
        // using two extra arrays one for result and
        // one for keep track of the element status if it has already taken or not
        List<List<Integer>> res = new ArrayList<>();
        boolean[] tracker = new boolean[nums.length];
        permuteHelper(nums, res, new ArrayList<>(), tracker);

        return res;

        // time: O(n * n!)
        // space: O(n)
    }

    private void permuteHelper(int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] tracker) {
        if (list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!tracker[i]){
                list.add(nums[i]);
                tracker[i] = true;
                permuteHelper(nums, res, list, tracker);
                // remove the element and change the tracker
                list.remove(list.size() - 1);
                tracker[i] = false;
            }
        }
    }

    public List<List<Integer>> permuteTwo(int[] nums) {
        // without using any extra data structure
        List<List<Integer>> ans = new ArrayList<>();
        permuteTwoHelper(nums, ans, 0);

        return ans;
        // time: O(n * n!)
        // space: O(n)
    }

    private void permuteTwoHelper(int[] nums, List<List<Integer>> ans, int index){
        if (index == nums.length){
            // copy array element to ArrayList
            List<Integer> list = new ArrayList<>();
            for (int num: nums){
                list.add(num);
            }

            ans.add(list);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // swap elements with the index for trying every arrangement
            swap(nums, index, i);
            permuteTwoHelper(nums, ans, index + 1);
            // swap back for back-tracking
            swap(nums, index, i);
        }

    }

    private void swap(int[] nums, int l, int h){
        int temp = nums[l];
        nums[l] = nums[h];
        nums[h] = temp;
    }
}
