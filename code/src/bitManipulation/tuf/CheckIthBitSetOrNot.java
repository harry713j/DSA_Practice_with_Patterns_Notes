package bitManipulation.tuf;


public class CheckIthBitSetOrNot {
    // brute-force: convert the number to binary and then retrieve the ith bit and check it is 1 or not (set means 1)
    // time: O(log n)
    // space: O(log n)

    public boolean check(int number, int i){
        // optimal: using left shift
        // we are assuming for int type
        if (i > 31 || i < 0){
            return false;
        }
        // left shift the one by i times and perform the `&` if it is not zero then the ith bit is set or 1
        return (number & (1 << i)) != 0;
        // time: O(1)
        // space: O(1)
    }

    public boolean checkTwo(int number, int i){
        // optimal: Using right shift
        if (i > 31 || i < 0){
            return false;
        }
        // right shift the number by i times and perform `&` with 1, if the result is one then true or false;
        return ((number >> i) & 1) == 1;
        // time: O(1)
        // space: O(1)
    }

    public static void main(String[] args) {
        System.out.println(new CheckIthBitSetOrNot().check(25, 0));
        System.out.println(new CheckIthBitSetOrNot().check(25, 4));
    }
}
