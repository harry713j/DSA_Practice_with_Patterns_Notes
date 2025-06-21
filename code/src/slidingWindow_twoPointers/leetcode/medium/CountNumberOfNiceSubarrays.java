package slidingWindow_twoPointers.leetcode.medium;

public class CountNumberOfNiceSubarrays {
    public int numberOfSubarrays(int[] nums, int k) {
        // brute-force: generate all the subarrays and count the odd number
        int totalCount = 0;

        for (int i = 0; i < nums.length; i++) {
            int oddNumbers = 0;

            for (int j = i; j < nums.length; j++) {
                if (nums[j] % 2 != 0){
                    oddNumbers++;
                }

                if (oddNumbers == k){
                    totalCount++;
                }
            }
        }

        return totalCount;
        // time: O(n^2), Time Limit Exceeded
        // space: O(1)
    }

    public int numberOfSubarraysTwo(int[] nums, int k) {
        // optimal : sliding window -> convert even number to 0 and odd number to 1
        int totalCount = 0, sum = 0;
        int l = 0, r = 0;
        int countOne = 0, countTwo = 0;

        while (r < nums.length){
            sum += nums[r] % 2;

            while (l <= r && sum > k){
                sum -= nums[l] % 2;
                l++;
            }

            countOne = countOne + (r - l + 1);
            r++;
        }

        l = 0; r = 0; sum = 0;

        while (r < nums.length){
            sum += nums[r] % 2;

            while (l <= r && sum >= k){
                sum -= nums[l] % 2;
                l++;
            }

            countTwo = countTwo + (r - l + 1);
            r++;
        }

        return countOne - countTwo;
        // time: O(n)
        // space: O(1)
    }
}
