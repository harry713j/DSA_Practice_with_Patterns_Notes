package bitManipulation.tuf;

public class CheckOddOrNot {
    // By bitwise
    public boolean isOdd(int n){
        // if the 0th bit is 1 then it is odd
        // e.g. 7 -> 111, 9 -> 1001

        return (n & 1) == 1;
        // time: O(1)
        // space: O(1)
    }
}
