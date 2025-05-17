package recursion.leetcode.medium;

// https://leetcode.com/problems/string-to-integer-atoi/
public class StringToIntegerAtoIRecursive {
    public int myAtoi(String s) {
        int sign = 1;
        double ans = 0;
        // we have to skip leading white spaces
        return myAtoiHelper(s, 0, sign, ans, false, false);
        // time: O(n)
        // space: O(n)
    }

    private int myAtoiHelper(String s, int index, int sign, double ans, boolean isDigitSeen, boolean isSignSeen){
        if (index == s.length()){
            ans = sign * ans;
            // we have to check for the overflow
            return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : ans < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) ans;
        }

        char ch = s.charAt(index);
        // skip the leading white spaces if ans=0
        if (ch == ' ' && !isDigitSeen && !isSignSeen && ans == 0){
            return myAtoiHelper(s, index + 1, sign, ans, isDigitSeen, isSignSeen);
        } else if (ans == 0 && !isDigitSeen && !isSignSeen && (ch == '+' || ch == '-')) {
            // determine the sign
            sign = ch == '-' ? -1 : 1;
            return myAtoiHelper(s, index + 1, sign, ans, isDigitSeen, true);
        } else if (Character.isDigit(ch)) {
            ans = ans * 10 + (ch - '0');
            return myAtoiHelper(s, index + 1, sign, ans, true, true);
        } else {
            // we will break
            ans = sign * ans;
            return ans > Integer.MAX_VALUE ? Integer.MAX_VALUE : ans < Integer.MIN_VALUE ? Integer.MIN_VALUE : (int) ans;
        }
    }

    public static void main(String[] args) {
        System.out.println(new StringToIntegerAtoIRecursive().myAtoi("   35729870012"));
    }
}
