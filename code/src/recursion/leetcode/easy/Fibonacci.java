package recursion.leetcode.easy;

// https://leetcode.com/problems/fibonacci-number/
public class Fibonacci {
    public int fib(int n) {
        int[] memo = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            memo[i] = -1;
        }

        return fibHelper(n, memo);
    }

    public int fibHelper(int n, int[] memo) {
        if (n <= 1) {
            memo[n] = n;
            return n;
        }

        if (memo[n - 2] == -1) {
            memo[n - 2] = fibHelper(n - 2, memo);
        }

        if (memo[n - 1] == -1) {
            memo[n - 1] = fibHelper(n - 1, memo);
        }

        memo[n] = memo[n - 2] + memo[n - 1];
        return memo[n - 2] + memo[n - 1];
    }
}
