package bitManipulation.tuf;

public class RemoveRightMostSetBit {
    // or last set bit
    // e.g. 25 = 11001 after removing 11000
    // brute-force: convert the number to binary and from last check the last set bit and make it unset and convert back to decimal
    // time: O(log n)
    // space: O(log n)

    public int removeLastSetBit(int num){
        // better: first we have to check the set bit , we can do that by masking
        // then we will change that bit to 0
        int i = 0;

        while (i < 32){
            if ((num & (1 << i)) != 0){
                // we found the set bit
                return num & ~(1 << i);
            }
            i++;
        }

        return -1;
        // time: O(1)
        // space: O(1)
    }

    public int removeLastSetBitTwo(int num){
        // optimal: if we take a number for example 13 its binary is 1101, while binary of 12 is 1100
        // for 40 -> 101000 and for 39 -> 100111
        // for 88 -> 1011000 and for 87 -> 1010111
        // if we carefully observe the pattern, for number-1 from the last set bit all the bits to right is changed
        // and all bits to left remain same
        // so if we do n & (n - 1) we can remove the last set bit
        return num & (num - 1);
        // time: O(1)
        // space: O(1)
    }

    public static void main(String[] args) {
        System.out.println(new RemoveRightMostSetBit().removeLastSetBit(25));
    }
}
