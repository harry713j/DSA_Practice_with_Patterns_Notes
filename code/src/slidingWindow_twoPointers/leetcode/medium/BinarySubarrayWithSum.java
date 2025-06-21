package slidingWindow_twoPointers.leetcode.medium;

public class BinarySubarrayWithSum {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // brute-force: generate all the sub array and find its sum
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];

                if (sum == goal){
                    count++;
                } else if (sum > goal) {
                    break;
                }
            }
        }

        return count;
        // time: O(n^2)
        // space: O(1)
    }

    public int numSubarraysWithSumTwo(int[] nums, int goal) {
        // optimal: sliding window, we have to count how many sub-arrays can be formed having sum <= goal and < goal
        // and their difference is our answer
        int count1 = 0, count2 = 0, sum = 0;
        int l = 0, r = 0;

        while (r < nums.length){
            sum += nums[r];

            while (l <= r && sum > goal){
                sum -= nums[l];
                l++;
            }
            count1 += (r - l + 1);
            r++;
        }

        l = 0; r = 0; sum = 0;

        while (r < nums.length){
            sum += nums[r];

            while (l <= r && sum >= goal){
                sum -= nums[l];
                l++;
            }
            count2 += (r - l + 1);
            r++;
        }

        return count1 - count2;
        // time: O(n)
        // space: O(1)
    }

    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};

        System.out.println(new BinarySubarrayWithSum().numSubarraysWithSumTwo(nums, 2));
    }
}
