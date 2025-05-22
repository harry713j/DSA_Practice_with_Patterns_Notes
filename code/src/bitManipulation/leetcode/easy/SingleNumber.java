package bitManipulation.leetcode.easy;

// https://leetcode.com/problems/single-number/
public class SingleNumber {
    // brute-force: sort the array and check which adjacent number are not equal
    // better: Using HashMap keep count , the element which have a count one that is the answer

    public int singleNumber(int[] nums) {
        // optimal: using XOR
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }

        return ans;
        // time: O(n)
        // space: O(1)
    }
}
