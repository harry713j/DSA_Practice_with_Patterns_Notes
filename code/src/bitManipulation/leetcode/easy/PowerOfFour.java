package bitManipulation.leetcode.easy;

// https://leetcode.com/problems/power-of-four
public class PowerOfFour {
    public boolean isPowerOfFour(int n) {
        // Optimal: using bit manipulation: A number to be the power of four it must have that only set digit (1) at even position
        // e.g : 1 -> 1, 4 -> 100, 16 -> 10000, 64 -> 1000000

        if (n < 1){
            return false;
        }

        // convert the number to binary and check its bits
        StringBuilder binary = new StringBuilder();
        while (n != 0){
            binary.append(n % 2);
            n = n / 2;
        }

        binary.reverse();

        if (binary.length() % 2 == 0){
            return false;
        }

        for (int i = 0; i < binary.length(); i++) {
            if (i != 0 && binary.charAt(i) == '1'){
                return false;
            }
        }

        return true;
        // time: O(log n)
        // space: O(log n)
    }

    public boolean isPowerOfFourTwo(int n) {
        if (n < 1){
            return false;
        }

        int position = 0;
        boolean isSetSeen = false;

        while (n != 0){
            int currentBit = n & 1;
            if (position % 2 != 0 && currentBit == 1){
                return false;
            } else if (position % 2 == 0 && currentBit == 1 && isSetSeen) {
                return false;
            }else if (position % 2 == 0 && currentBit == 1){
                isSetSeen = true;
            }
            position++;
            n = n >> 1;
        }

        return true;
        // time: O(log n)
        // space: O(1)
    }

    public boolean isPowerOfFourThree(int n) {
        if (n < 1){
            return false;
        }

        return (n & (n - 1)) == 0 && ((n - 1) % 3) == 0;
        // time: O(1)
        // space: O(1)
    }
}
