package array.leetcode.easy;

// https://leetcode.com/problems/majority-element/
public class MajorityElement {
    public int majorityElement(int[] nums) {
        // Boyer-Moore's Voting Algorithm
        int count = 0, candidate = 0;

        for(int num : nums){
            if (count == 0){
                candidate = num;
            }

            if (num == candidate){
                count++;
            } else {
                count--;
            }
        }

        return candidate;
    }
}
