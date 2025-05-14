package math.leetcode.easy;

// https://leetcode.com/problems/palindrome-number/description/
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if(x < 0){
            return false;
        }

        int rev = 0; // for reversing the value
        int org = x; // original value

        while(x > 0){
            rev = rev * 10 + x % 10;
            x /= 10;
        }

        return org == rev;
        // Time: O(log10n)
        // Space: O(1)
    }
}
