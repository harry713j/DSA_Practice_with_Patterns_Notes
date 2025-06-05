package recursion.leetcode.medium;

// https://leetcode.com/problems/powx-n/
public class Power {
    public double myPow(double x, int n) {
        // brute-force: the base and exponent could be negative, so run a for loop and calculate the result
        // if it is negative then 1/result otherwise result itself
        if (x == 0){
            return 0;
        }

        boolean isExponentNegative = n < 0;
        double result = 1;

        for (int i = 1; i <= (isExponentNegative ? -n : n); i++) {
            result *= x;
        }

        if (isExponentNegative){
            return 1 / result;
        }

        return result;
        // time: O(n)
        // space: O(1)
    }

    public double myPowTwo(double x, int n) {
        // optimal solution:
        if (x == 0){
            return 0;
        }


        boolean isExponentNegative = n < 0;
        double result = 1;
        double base = x;
        long exp = Math.abs((long) n);


        while (exp > 0){
            if (exp % 2 != 0){
                result *= base;
                exp--;
            } else {
                // if the exponent is even then we will double the base
                base = base * base;
                exp = exp / 2;
            }
        }

        if (isExponentNegative){
            return 1 / result;
        }

        return result;
        // time: O(log n)
        // space: O(1)
    }

    public double myPowRecursive(double x, int n) {
        if (x == 0){
            return 0;
        }
        long exp = Math.abs((long) n);
        boolean isExpNegative = n < 0;
        double res = myPowRecursiveHelper(x, exp);

        return isExpNegative ? 1 / res : res;
        // time: O(log n)
        // space: O(log n)
    }

    private double myPowRecursiveHelper(double base, long exp) {
        if (exp == 0){
            return 1;
        }

        // exponent is even then base = base * base
        if (exp % 2 == 0){
            return 1 * myPowRecursiveHelper(base * base, exp / 2);
        }

        return base * myPowRecursiveHelper(base, exp - 1);
    }

    public static void main(String[] args) {
        double x = 2.00000;
        int n = -2147483648;
        System.out.println(new Power().myPowTwo(x, n));
    }
}
