package math.leetcode.easy;

public class ArmstrongNumber {
//    An Armstrong number, also known as a narcissistic number or plenary number, is a number that is
//    equal to the sum of its own digits each raised to the power of the number of digits.
//
//    Number of digits: 3, 153 = 13+53+33
    public boolean isArmstrong(int num){
        int noOfDigits = (int) Math.log10(num) + 1;
        int calculatedNumber = 0;
        int originalNumber = num;

        while (num > 0){
            int rem = num % 10;
            calculatedNumber = calculatedNumber + (int) Math.pow(rem, noOfDigits);
            num = num / 10;
        }

        return originalNumber == calculatedNumber;
        // Time: O(log10 N)
        // Space: O(1)
    }
}
