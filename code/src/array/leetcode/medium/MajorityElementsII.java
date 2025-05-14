package array.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/majority-element-ii/
public class MajorityElementsII {
    public List<Integer> majorityElement(int[] nums) {
        // brute-force: run a for loop for each element count the occurrence,
        // if count is greater than n/3 then add it to the ans
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int j : nums) {
            int count = 0;
            for (int num : nums) {
                if (j == num) {
                    count++;
                }
            }
            if (count > n / 3){
                ans.add(j);
            }
        }

        return ans;
        // time: O(n^2)
        // space: O(1)
    }

    public List<Integer> majorityElementTwo(int[] nums) {
        // better approach: Use a hash map to store the elements and its occurrence,
        // if occurrence greater than n/3 then add it to the ans
        List<Integer> ans = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        int n = nums.length;

        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (Integer key: count.keySet()){
            if (count.get(key) > n / 3){
                ans.add(key);
            }
        }

        return ans;
        // time: O(n)
        // space: O(n)
    }

    public List<Integer> majorityElementThree(int[] nums) {
        // optimal: Extended version of Boyer-Moore's Voting Algorithm
        int count1 = 0, count2 = 0;
        int candidate1 = Integer.MIN_VALUE, candidate2 = Integer.MIN_VALUE;

        List<Integer> ans = new ArrayList<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (count1 == 0 && candidate2 != nums[i]){
                count1 = 1;
                candidate1 = nums[i];
            } else if (count2 == 0 && candidate1 != nums[i]) {
                count2 = 1;
                candidate2 = nums[i];
            } else if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        // we check the candidate1 and candidate2 appeared
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate1){
                count1++;
            }
            if (nums[i] == candidate2){
                count2++;
            }
        }

        // if count is greater than n/3 then we will add
        if (count1 > n / 3) ans.add(candidate1);
        if (count2 > n / 3) ans.add(candidate2);

        return ans;
        // time: O(n)
        // space: O(1)
    }
}
