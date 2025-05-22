package bitManipulation.leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/single-number-iii/
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        // brute-force: keep counter of the number using hashmap, if any number appearing only once add it to the answer
        int[] ans = new int[2];

        Map<Integer, Integer> counter = new HashMap<>();

        for (int num: nums){
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> ent: counter.entrySet()){
            if (ent.getValue() == 1){
                ans[i++] = ent.getKey();
            }
        }

        return ans;
        // time: O(n)
        // space: O(n)
    }

    public int[] singleNumberTwo(int[] nums) {
        // sort the array then equal element will be adjacent
        int[] ans = new int[2];
        int i = 0, j = 0;
        Arrays.sort(nums);

        while (i < nums.length){
            if (i + 1 < nums.length && nums[i] == nums[i + 1]){
                i += 2;
            } else {
                ans[j++] = nums[i];
                i++;
            }
        }

        return ans;
        // time: O(n log n)
        // space: O(1)
    }

    public int[] singleNumberThree(int[] nums) {
        // optimal: Using XOR
        // Intuition: e.g: [1, 2, 1, 3, 2, 5], if we XOR them the result will be XOR of two numbers that are appearing once
        //  i.e. 3 ^ 5 = 6, 6 = 110 in binary, the bits those are 0 indicates the corresponding bits of two numbers are same
        //  and the bits those are one the corresponding bits of two numbers are different, so we need to identify the right most
        //  set or 1 bit of XOR result that's how we can differentiate between two numbers, we will store the bits of numbers
        //  at that position are 1 in a variable and 0's in other variable or bucket by XORing them, at last we will get our
        //  two different numbers

        int xor = 0;
        for (int num : nums){
            xor ^= num;
        }

        // right most different bit
        int differentBit = (xor & (xor - 1)) ^ xor; // xor ^ -xor also give the same result

        int a = 0, b = 0; // buckets for storing the elements

        for (int num : nums){
            // check if the element's bit at the position of different bit is 0 or 1
            if ((num & differentBit) != 0){
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
        // time: O(n)
        // space: O(1)
    }
}
