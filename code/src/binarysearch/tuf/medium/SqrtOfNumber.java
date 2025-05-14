package binarysearch.tuf.medium;

// https://takeuforward.org/binary-search/finding-sqrt-of-a-number-using-binary-search/
public class SqrtOfNumber {
    public int sqrt(int num){
    // brute-force: run a loop till the number/2 and check each number's square is matching with the given number
        int floorSqrt = 0;

        for (int i = 1; i <= num / 2; i++) {
            long square = (long) i * i;
            if (square <= (long) num){
                floorSqrt = i;
            }
        }
        return floorSqrt;
        // time: O(n)
        // space: O(1)
    }

    public int sqrtTwo(int num){
        int s = 1, e = num / 2;

        while (s <= e){
            int m = (s + e) / 2;
            long square = (long) m * m;

            if (square == (long) num){
                return m;
            } else if (square > (long) num){
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return e;
        // time: O(log n)
        // space: O(1)
    }
}
