package array.leetcode.medium;

public class LeetCodeMediumQuestions {

    static int[] productExceptSelf(int[] nums) {
    // https://leetcode.com/problems/product-of-array-except-self/
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
    }


    static int[] searchRange(int[] nums, int target) {
    // https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
        int[] result = {-1 , -1};
        if(nums.length == 0){
            return result;
        }

        int start = 0, end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] < target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if(start >= nums.length || nums[start] != target){
            return result;
        }

        result[0] = start;

        end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(nums[mid] > target){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        result[1] = end;

        return result;
    }

    static boolean canJump(int[] nums) {
    // https://leetcode.com/problems/jump-game/ (Greedy) IMPORTANT:
        int maxReach = 0;

        for(int i = 0; i < nums.length; i++){
            if(i > maxReach){
                return false;
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if(maxReach >= nums.length - 1){
                return true;
            }

        }

        return true;
    }

    static void reverse(int[] nums,int start, int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    static void rotate(int[] nums, int k) {
        //  https://leetcode.com/problems/rotate-array/description/

//        k = k % nums.length; // Brute-force rotating the last element of the array on every pass
//
//        for(int i = 0; i < k; i++){
//            int previous = nums[nums.length -  1];
//            for(int j = 0; j < nums.length; j++){
//                int temp = nums[j];
//                nums[j] = previous;
//                previous = temp;
//            }
//        }

        k = k % nums.length;
        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);
    }

    static int rob(int[] nums) {
    // https://leetcode.com/problems/house-robber/
        int evenSum = 0, oddSum = 0;

        for(int i = 0; i < nums.length; i++){
            if(i % 2 == 0){
                evenSum = Math.max(evenSum + nums[i], oddSum);
            } else {
                oddSum = Math.max(oddSum + nums[i], evenSum);
            }
        }

        return Math.max(evenSum, oddSum);
    }

    static int minSubArrayLen(int target, int[] nums) {
       // https://leetcode.com/problems/minimum-size-subarray-sum/
        int minSize = Integer.MAX_VALUE, runningSum = 0;
        int windowStart = 0;

        for(int i = 0; i < nums.length; i++){
            runningSum += nums[i];

            while(runningSum >= target){
                minSize = Math.min(minSize, i - windowStart + 1);
                runningSum -= nums[windowStart];
                windowStart++;
            }
        }

        return minSize != Integer.MAX_VALUE ? minSize : 0;
    }

    static int maxSubArray(int[] nums) {
    // https://leetcode.com/problems/maximum-subarray/
        // Kadane's Algorithm
        int maxSum = nums[0];
        int currSum = 0;

        for(int i = 0; i < nums.length; i++){
            if(currSum < 0){
                currSum = 0;
            }

            currSum += nums[i];
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(productExceptSelf(new int[]{-1, 1, 0, -3, 3, 0})));
//        System.out.println(Arrays.toString(searchRange(new int[]{1, 2, 3, 6, 6, 8, 8, 10, 10, 10, 13},
//                10)));
//        System.out.println(minSubArrayLen(11, new int[]{1,1,1,1,1,1,1,1}));
        System.out.println(maxSubArray(new int[]{5, 4, -1, 7, 8}));


    }
}
