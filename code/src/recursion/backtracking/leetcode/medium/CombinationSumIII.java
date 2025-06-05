package recursion.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum-iii/
public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        // here we don't have the array to backtrack instead it is stated that the number should be in the range 1-9, so we will choose from
        // 1-9 of length k and sum equal to n
        List<List<Integer>> ans = new ArrayList<>();

        combinationSum3Helper(1, k, n,  new ArrayList<>(), ans);

        return ans;
        // time: O(2^9 * k)
        // space: O(2^9 * k)
    }

    private void combinationSum3Helper(int start, int k, int targetSum,  List<Integer> ds, List<List<Integer>> ans) {
        if (ds.size() > k || targetSum < 0){
            return;
        }

        if (ds.size() == k && targetSum == 0){
            ans.add(new ArrayList<>(ds));
            return;
        }

        // Iterate through numbers from startNum to 9
        for (int i = start; i <= 9; i++) {
            // Pruning: if adding the current number exceeds the targetSum, no need to proceed with larger numbers
            // (since numbers are increasing)
            if (i > targetSum) { // Only prune if targetSum is non-negative
                break;
            }

            ds.add(i); // Choose the current number
            // Recursively call with next number (i+1) to ensure unique numbers in combination
            combinationSum3Helper(i + 1, k, targetSum - i, ds, ans);
            ds.remove(ds.size() - 1); // Backtrack
        }

    }

    public static void main(String[] args) {
        List<List<Integer>> ans = new CombinationSumIII().combinationSum3(3, 9);

        for (List<Integer> l : ans){
            System.out.println(l);
        }
    }
}
