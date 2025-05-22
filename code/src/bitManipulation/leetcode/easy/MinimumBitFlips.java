package bitManipulation.leetcode.easy;

// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/
public class MinimumBitFlips {
    public int minBitFlips(int start, int goal) {
        // brute-force: convert both the number to binary and check their each bit, if there is mismatch then increase the counter
        StringBuilder startBin = toBinary(start);
        StringBuilder goalBin = toBinary(goal);

        int count = 0; // counter check how many bits are different;
        for (int i = 0; i < 32; i++) {
            if (startBin.charAt(i) != goalBin.charAt(i)){
                count++;
            }
        }

        return count;
        // time: O(log n)
        // space: O(log n)
    }

    private StringBuilder toBinary(int start) {
        StringBuilder res = new StringBuilder();

        while (start != 0){
            int rem = start % 2;
            res.append(rem);
            start = start / 2;
        }

        int len = res.length();

        // append zeros
        for (int i = 0; i < 32 - len; i++) {
            res.append('0');
        }

        // reverse it
        res.reverse();

        return res;
    }

    public int minBitFlipsTwo(int start, int goal) {
        // optimal: we can solve this without using any extra space and with one pass
        // using right shift and `&`

        int bigger = Math.max(start, goal); // Log (bigger) number of time we will run the loop
        int count = 0;

        while (bigger != 0){
            int firstBitOfStart = start & 1;
            int firstBitOfGoal = goal & 1;

            if (firstBitOfStart != firstBitOfGoal){
                count++;
            }

            start = start >> 1;
            goal = goal >> 1;
            bigger = bigger >> 1;
        }

        return count;
        // time: O(log n) at most 32 times the loop will run so it can be O(1)
        // space: O(1)
    }

    public int minBitFlipsThree(int start, int goal) {
        // optimal: Using XOR
        int count = 0;
        // by doing XOR the bits are same will be 0 and different bits will be 1
        // so we will count the 1's
        int xor = start ^ goal;

        while (xor != 0){
            count += xor & 1;

            // right shift the xor
            xor = xor >> 1;
        }

        return count;
        // time: O(log n) n is the max number of bits
        // space: O(1)
    }


    public static void main(String[] args) {
        System.out.println(new MinimumBitFlips().minBitFlipsTwo(10, 7));
    }
}
