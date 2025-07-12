package array.leetcode.medium;

// https://leetcode.com/problems/product-of-array-except-self/
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length < 2){
            return nums;
        }

        int n = nums.length;
        int[] result = new int[n];
        result[0] = 1;

        // in this pass the for each element in nums the left side product will be store in result
        for(int i = 1; i < n; i++){
            result[i] = result[i - 1] * nums[i - 1];
        }

        // in this pass the right side product will be store in result
        int rightProduct = 1;

        for(int i = n - 1; i >= 0; i--){
            result[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return result;
        // time: O(n)
        // space: O(1)
    }
}
