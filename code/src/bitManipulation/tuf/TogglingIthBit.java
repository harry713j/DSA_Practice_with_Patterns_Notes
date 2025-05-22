package bitManipulation.tuf;

public class TogglingIthBit {
    // Q: Change bit to 1 if it is 0 or 0 if it is 1
    // brute-force: convert the number to binary and toggle the ith bit and then convert it back to decimal
    // time: O(log n)
    // space: O(log n)

    public int toggle(int number, int i){
        // optimal: left shift and XOR
        // left shift the 1 by i times and perform XOR with the number
        return number ^ (1 << i);
        // time: O(1)
        // space: O(1)
    }

    public static void main(String[] args) {
        System.out.println(new TogglingIthBit().toggle(25, 2));
        System.out.println(new TogglingIthBit().toggle(29, 2));
    }
}
