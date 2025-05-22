package bitManipulation.leetcode.easy;

// https://leetcode.com/problems/power-of-two/
public class PowerOfTwo {
    public boolean isPowerOfTwo(int n) {
        // optimal: lets take example of few numbers
        // 16 -> 10000 , 8 -> 1000 , 32 -> 100000 (these numbers have only one 1)
        // 15 -> 01111 , 7 -> 0111,  31 -> 011111
        // if we carefully observe the pattern 16 & 15 will give 0 , so as 32 & 31 and 8 & 7

        if (n < 1){
            return false;
        }

        return (n & (n - 1)) == 0;
        // time: O(1)
        // space: O(1)
    }
}
