package bitManipulation.leetcode.easy;

// https://leetcode.com/problems/hamming-distance/
public class HammingDistance {
    // brute-force: convert to binary and match their bits
    public int hammingDistance(int x, int y) {
        // optimal: xor, by doing xor of two number the different bits will be 1 and same bit will be 0, so count the 1 bits
        int xor = x ^ y;
        int count = 0;

        while (xor != 0){
            count += xor & 1;
            xor = xor >> 1;
        }

        return count;
        // time: O(log n)
        // space: O(1)
    }
}
