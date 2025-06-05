package recursion.backtracking.tuf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://takeuforward.org/plus/dsa/problems/subsets-i
public class SubsetSumI {
    public List<Integer> subsetSums(int[] nums) {
       // generate every subset sum and put them in ans
        List<Integer> ans = new ArrayList<>();
        backtrack(nums, 0, 0, ans);

        Collections.sort(ans);
        return ans;
        // time: O(2^n)
        // space: O(n)
    }

    private void backtrack(int[] nums, int index, int sum, List<Integer> ans) {
        if (index == nums.length){
            ans.add(sum);
            return;
        }

        // pick
        sum += nums[index];
        backtrack(nums, index + 1, sum, ans);
        sum -= nums[index];

        // do not pick
        backtrack(nums, index + 1, sum, ans);
    }

    public static void main(String[] args) {
        System.out.println(new SubsetSumI().subsetSums(new int[]{5, 2, 1}));
    }
}
