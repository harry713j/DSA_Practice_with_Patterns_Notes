package bitManipulation.leetcode.medium;

// https://leetcode.com/problems/sum-of-two-integers/
public class SumOfInteger {
    // explanation:
    // https://leetcode.com/problems/sum-of-two-integers/solutions/132479/simple-explanation-on-how-to-arrive-at-the-solution/
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b);
            a = a ^ b;
            b = (carry) << 1;
        }
        return a;
        // time: O(1)
        // space: O(1)
    }

    public static void main(String[] args) {
        System.out.println(new SumOfInteger().getSum(1, -1));
    }
}
