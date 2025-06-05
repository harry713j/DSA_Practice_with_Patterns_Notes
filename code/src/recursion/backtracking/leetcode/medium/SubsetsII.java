package recursion.backtracking.leetcode.medium;

import java.util.*;

// https://leetcode.com/problems/subsets-ii/
public class SubsetsII {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // brute-force
        Set<List<Integer>> ans = new HashSet<>();
        // sort the array for indicating duplicate
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, 0, new ArrayList<>(), ans);

        return new ArrayList<>(ans);
        // time: O(2^n * n log k) , k is average size of the list
        // space: O(2^n)
    }

    private void subsetsWithDupHelper(int[] nums, int index, List<Integer> ds, Set<List<Integer>> ans) {
        if (index == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }

        // pick
        ds.add(nums[index]);
        subsetsWithDupHelper(nums, index + 1, ds, ans);
        ds.remove(ds.size() - 1);

        subsetsWithDupHelper(nums, index + 1, ds, ans);
    }

    public List<List<Integer>> subsetsWithDupTwo(int[] nums) {
        // optimal
        List<List<Integer>> ans = new ArrayList<>();
        // sort the array for indicating duplicate
        Arrays.sort(nums);
        subsetsWithDupHelperTwo(nums, 0, new ArrayList<>(), ans);

        return ans;
        // time: O(2^n * n)
        // space: O(2^n * n)
    }

    private void subsetsWithDupHelperTwo(int[] nums, int index, List<Integer> ds, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(ds));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1])
                continue;

            ds.add(nums[i]);
            subsetsWithDupHelperTwo(nums, i + 1, ds, ans);
            ds.remove(ds.size() - 1);
        }
    }

    public static void main(String[] args){
        List<List<Integer>> ans = new SubsetsII().subsetsWithDupTwo(new int[]{2, 5, 2, 1, 2});
        for (List<Integer> l : ans){
            System.out.println(l);
        }
    }
}
