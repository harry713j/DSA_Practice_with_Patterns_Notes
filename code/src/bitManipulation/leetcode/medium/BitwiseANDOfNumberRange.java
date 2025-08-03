package bitManipulation.leetcode.medium;

// https://leetcode.com/problems/bitwise-and-of-numbers-range/description/
public class BitwiseANDOfNumberRange {
    public int rangeBitwiseAnd(int left, int right) {
        // brute-force
        int res = left;
        for (int i = left + 1; i <= right; i++) {
            res = res & i;
        }
        return res;
        // time: O(right - left)
        // space: O(1)
    }

    public int rangeBitwiseAndTwo(int left, int right) {
        int count = 0;
        while (left != right){
            left = left >> 1;
            right = right >> 1;
            count++;
        }
        return left << count;
        // time: O(log2 n), n = right
        // space: O(1)
    }

    public int rangeBitwiseAndThree(int left, int right) {

        while (right > left){
            right = right & (right - 1);
        }

        return left & right;
        // time: O(log2 n), n = right
        // space: O(1)
    }

    public static void main(String[] args) {
        System.out.println(new BitwiseANDOfNumberRange().rangeBitwiseAndThree(1, 2147483647));
    }
}
