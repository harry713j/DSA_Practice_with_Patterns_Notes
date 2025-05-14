package binarysearch.leetcode.medium;

// https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
public class SmallestDivisorGivenThreshold {
    // intuition: we are taking the ceil of dividing value,
    // so it will always be one for divisor <= greatest number in the array , so we check from 1 to
    // max element in the array and accumulate their dividing result,
    // if it is less than equal to threshold then it is the answer
    public int smallestDivisor(int[] nums, int threshold) {
        // brute-force: run loop from 1 to max number in the array, and sum up the dividing value
        // if threshold is less than length of the array then twe will return -1
        if(threshold < nums.length){
            return -1;
        }
        int max = maximum(nums);

        for (int i = 1; i <= max; i++) {
            int sum = calculateSum(nums, i);

            if (sum <= threshold){
                return i;
            }
        }

        return -1;
        // time: O(max * n)
        // space: O(1)
    }

    private int calculateSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil((double) num / divisor);
        }

        return sum;
    }

    private int maximum(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num: nums){
            max = Math.max(max, num);
        }

        return max;
    }

    public int smallestDivisorTwo(int[] nums, int threshold) {
        // optimal: as we are searching in the range from 1 to max element of array,
        // we can reduce that searching by using binary-search
        // if threshold is less than length of the array then twe will return -1
        if (threshold < nums.length){
            return -1;
        }

        int start = 1;
        int end = maximum(nums);

        while (start <= end){
            int mid = (start + end) / 2;
            int sum = calculateSum(nums, mid);

            if (sum <= threshold){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return start;
        // time: O(n log (max))
        // space: O(1)
    }

    public static void main(String[] args) {
        int[] nums = {1,2,5,9};
        System.out.println(new SmallestDivisorGivenThreshold().smallestDivisor(nums, 6));
    }

}
