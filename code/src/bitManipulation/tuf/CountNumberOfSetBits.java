package bitManipulation.tuf;

public class CountNumberOfSetBits {
    // brute-force: convert the number into binary and count the number of 1's in it;
    // time: O(log n)
    // space: O(log n)

    public int count(int n){
        // optimal: right shift the number and do the &
        if (n == 0){
            return 0;
        }

        int count = 0;

        while (n > 0){
            if ((n & 1) == 1){
                count++;
            }
            n = n >> 1;
        }

        return count;
        // time: O(log n)
        // space: O(1)
    }

    public int countTwo(int n){
        // optimal:
        if (n == 0){
            return 0;
        }

        int count = 0;

        while (n > 0){
            if (n % 2 == 1){
                count++;
            }
            n = n / 2;
        }

        return count;
        // time: O(log n)
        // space: O(1)
    }

    public int countThree(int n){
        // optimalMax: by doing n & (n-1) , we eliminate the right most set bit
        // if we continue doing it we will eliminate all the set bits and we can keep a counter of it
        int count = 0;

        while (n != 0){
            n = n & (n - 1);
            count++;
        }

        return count;
        // time: O(number of set bits)
        // space: O(1)
    }

    public static void main(String[] args) {
        System.out.println(new CountNumberOfSetBits().count(13));
        System.out.println(new CountNumberOfSetBits().countTwo(13));
    }
}
