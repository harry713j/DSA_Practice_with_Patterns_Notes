package recursion.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        combinationSumHelper(candidates, target, ans, new ArrayList<Integer>(), 0, 0);

        return ans;
        /*
            Time Complexity: O(2^t * k) where t is the target, k is the average length
            Reason: Assume if you were not allowed to pick a single element multiple times,
            every element will have a couple of options: pick or not pick which is 2^n different recursion calls,
            also assuming that the average length of every combination generated is k.
            (to put length k data structure into another data structure)
            Why not (2^n) but (2^t) (where n is the size of an array)?
            Assume that there is 1 and the target you want to reach is 10 so 10 times you can “pick or not pick” an element.
            Space Complexity: O(k*x), k is the average length and x is the no. of combinations
        * */
    }

    private void combinationSumHelper(int[] nums, int target, List<List<Integer>> ans, List<Integer> ds, int index, int sum) {
        if (sum == target){
            ans.add(new ArrayList<>(ds));
            return;
        }

        if (sum > target || index >= nums.length){
            return;
        }

        // pick the element
        ds.add(nums[index]);
        sum += nums[index];
        combinationSumHelper(nums, target, ans, ds, index, sum);
        // back-tracking
        ds.remove(ds.size() - 1);
        sum -= nums[index];

        // do not pick the element
        combinationSumHelper(nums, target, ans, ds, index + 1, sum);
    }

    public static void main(String[] args) {
        for (List<Integer> l: new CombinationSum().combinationSum(new int[]{2, 5, 2, 1, 2}, 5)){
            System.out.println(l);
        }
    }
}
