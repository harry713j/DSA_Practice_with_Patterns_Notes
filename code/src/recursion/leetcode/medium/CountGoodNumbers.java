package recursion.leetcode.medium;

// https://leetcode.com/problems/count-good-numbers/
public class CountGoodNumbers {
    // intuition: at even position we must put the even digits i.e. we have 5 choices (0, 2, 4, 6, 8) and
    // at odd position we must put prime digits i.e. we have 4 choices(2,3,5,7), if we can remember combinatorics,
    // we have to multiply the possibilities
    // e.g: if we are given n = 6, then we have 3 even position and 3 odd position so our answer will be 5^3*4^3 % 10^9+7
    public int countGoodNumbers(long n) {
        // mod for do modulo operation on answer
        final long MOD = (long) (Math.pow(10, 9) + 7);

        long even = (n + 1) / 2; // total number of even positions
        long odd = n / 2; // total number of odd positions

        return (int) ((power(5, even, MOD) * power(4, odd, MOD)) % MOD);
        // time: O(log n)
        // space: O(1)
    }

    private long power(long base, long exp, long mod){
        long res = 1;
        while (exp > 0){
            if (exp % 2 == 0){
                base = (base * base) % mod;
                exp = exp / 2;
            } else {
                res = (res * base) % mod;
                exp = exp - 1;
            }
        }

        return res;
    }

    // recursive
    public int countGoodNumbersRecursive(long n) {
        // mod for do modulo operation on answer
        final long MOD = (long) (Math.pow(10, 9) + 7);

        long even = (n + 1) / 2; // total number of even positions
        long odd = n / 2; // total number of odd positions

        return (int) ((powerRecursive(5, even, MOD) * powerRecursive(4, odd, MOD)) % MOD);
        // time: O(log n)
        // space: O(log n)
    }

    private long powerRecursive(long base, long exp, long mod){
        if (exp == 0){
            return 1;
        }

        if (exp % 2 == 0){
            return powerRecursive((base * base) % mod, exp / 2, mod);
        }

        return (base * powerRecursive(base, exp - 1, mod)) % mod;
    }

    public static void main(String[] args) {
        System.out.println(new CountGoodNumbers().countGoodNumbers(50));
    }
}
