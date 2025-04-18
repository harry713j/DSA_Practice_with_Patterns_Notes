package prefixsum.leetcode.easy;

// Range Sum Query - https://leetcode.com/problems/range-sum-query-immutable/
public class NumArray {
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;

        // pre-process the array
        for (int i = 1; i < this.nums.length; i++) {
            this.nums[i] = this.nums[i - 1] + this.nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // if left = 0 then we can simply return the element at right index
        if (left == 0){
            return nums[right];
        } else {
            // sum till last index i.e. nums[right] minus with sum till left - 1 index
            return nums[right] - nums[left - 1];
        }
    }
}
