package bitManipulation.tuf;

public class ClearIthBit {
    //Q: make the ith bit in a number to 0
    // brute-force: convert the number to binary and then change the ith bit to 0 and convert it back to decimal
    // time: O(log n)
    // space: O(log n)

    public int clear(int number, int i){
        // optimal: using left shift and `|` operator
        // left shift 1 by ith bit then flip its bits and perform &

        return number & ~(1 << i);
        // time: O(1)
        // space: O(1)
    }

    public static void main(String[] args) {
        System.out.println(new ClearIthBit().clear(13, 2));
    }
}
