package array.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
public class FindAllNumberDisappearedFromArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[nums.length + 1];

        for (int num: nums){
            count[num]++;
        }

        for (int i = 1; i < count.length; i++) {
            if (count[i] == 0){
                ans.add(i);
            }
        }

        return ans;
        // Time: O(n)
        // Space: O(n)
    }

    public List<Integer> findDisappearedNumbersTwo(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int i = 0;
        while (i < nums.length){
            // if the number n is not at the n - 1 index then we will bring that to it
            if (nums[nums[i] - 1] != nums[i]){
                // swap
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            } else{
                i++;
            }
        }

        // if the numbers are not in its correct index then add it to ans
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1){
                ans.add(j + 1);
            }
        }
        return ans;
        // Time: O(n)
        // Space: O(1)
    }

}
