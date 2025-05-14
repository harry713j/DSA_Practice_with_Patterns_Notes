package binarysearch.tuf.medium;

// https://takeuforward.org/data-structure/nth-root-of-a-number-using-binary-search/
public class NthRootOfNumber {
    private long power(int b, int exp){
        long ans = 1;
        long base = b;

        while (exp > 0){
            if (exp % 2 == 0){
                exp /= 2;
                base = base * base;
            } else {
                exp--;
                ans = ans * base;
            }
        }

        return ans;
    }

    public int nthRoot(int n, int m){
        // brute-force: linear search from 1 to n and for each number we will
        // raise it to the power of n check if it is equal to m or not
        for (int i = 1; i <= m / 3; i++) {
            long value = power(i, n);
            if (value == (long) m){
                return i;
            } else if (value > (long) m){
                break;
            }
        }

        return -1;
        // time : O(m)
        // space: O(1)
    }

    public int nthRootTwo(int n, int num){
        // optimal: binary-search
        int s = 1, e = num;
        while (s <= e){
            int m = (s + e) / 2;
            long value = power(m, n);

            if (value == (long) num){
                return m;
            } else if (value > (long) num) {
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return -1;
        // time: O(log m * log n)
        // space: O(1)
    }
}
