package array.leetcode.medium;

// https://leetcode.com/problems/rearrange-array-elements-by-sign/
public class RearrangeArrayBySign {
    public int[] rearrangeArray(int[] nums) {
        int[] res = new int[nums.length];
        int evenIndex = 0, oddIndex = 1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0){
                res[evenIndex] = nums[i];
                evenIndex += 2;
            } else {
                res[oddIndex] = nums[i];
                oddIndex += 2;
            }
        }

        return res;
        // Time: O(n)
        // Space: O(n)
    }
}
