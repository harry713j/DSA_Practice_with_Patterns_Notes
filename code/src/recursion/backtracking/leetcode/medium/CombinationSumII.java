package recursion.backtracking.leetcode.medium;


import java.util.*;

// imp: https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSum2Helper(candidates, target, ans, new ArrayList<>(), 0);

        return ans;
        // time: O(2^n * k), k = average length of each sub-sequence, k used because we are inserting sub-sequence to ans
        // space: O(n)
    }

    private void combinationSum2Helper(int[] nums, int target, List<List<Integer>> ans, List<Integer> ds, int index) {
        // intuition: We are gonna avoid picking the same element as pick to avoid duplicate combination
        if (target == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < nums.length; i++) {
            // if we have duplicate elements skip taking the duplicate
            if (i > index && nums[i] == nums[i - 1]) continue;
            // if we have combination sum greater than target
            if (nums[i] > target) break;

            ds.add(nums[i]);
            combinationSum2Helper(nums, target - nums[i], ans, ds, i + 1);
            // back-track
            ds.remove(ds.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new CombinationSumII().combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);

        for (List<Integer> l : ans){
            System.out.println(l);
        }
    }
}
