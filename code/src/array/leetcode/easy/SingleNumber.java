package array.leetcode.easy;
// https://leetcode.com/problems/single-number/
public class SingleNumber {
    /*
    * 1. we can linear search each element and keep a count of it if count == 1 then that is the answer
    * 2. We can use hashing or hash map and store the number of occurrence of the elements
    * 3. We can use XOR(^) operation, in XOR if there is same element it will be 0
    * */
    public int singleNumber(int[] nums) {
        int num = 0;
        for (int n : nums){
            num ^= n;
        }
        return num;
        // Time: O(n)
        // Space: O(n)
    }
}
