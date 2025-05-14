package math.leetcode.medium;

// https://leetcode.com/problems/reverse-integer/
public class ReverseInteger {
    public int reverse(int x) {
       int res = 0;
       boolean isNegative = false;

       if (x < 0){
           isNegative = true;
           // return 0 if it is minimum integer value
           if (x == Integer.MIN_VALUE){
               return 0;
           }
           x = -x;
       }

       while (x != 0){
           int lastDigit = x % 10;
           // before adding checking if overflow could happen
           if (res > (Integer.MAX_VALUE - lastDigit) / 10){
               return 0;
           }

           res = res * 10 + lastDigit;
           x = x / 10;
       }

       return isNegative ? -res : res;
       // Time: O(log10n)
        // Space: O(1)
    }
}
