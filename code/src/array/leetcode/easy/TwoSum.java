package array.leetcode.easy;

import java.util.HashMap;

// https://leetcode.com/problems/two-sum/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        if (nums.length < 2){
            return new int[]{};
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                return new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }
}
