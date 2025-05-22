package bitManipulation.tuf;

public class SetIthBit {
    // Q: make the ith bit in a number to 1
    // brute-force: convert the number to binary and then change the ith bit to 1 and convert it back to decimal
    // time: O(log n)
    // space: O(log n)

    public int set(int number, int i){
        // optimal: using left shift and `|` operator
        // left shift 1 by i times and perform the `|` with the number
        return number | (1 << i);
        // time: O(1)
        // space: O(1)
    }

    public static void main(String[] args) {
        System.out.println(new SetIthBit().set(25, 2));
    }
}
