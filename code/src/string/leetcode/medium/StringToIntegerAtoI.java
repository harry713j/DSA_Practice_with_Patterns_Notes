package string.leetcode.medium;

// https://leetcode.com/problems/string-to-integer-atoi/
public class StringToIntegerAtoI {
    public int myAtoi(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (ans.isEmpty() && s.charAt(i) == ' '){
                continue;
            } else if (ans.isEmpty() && (s.charAt(i) == '-' || s.charAt(i) == '+')){
                ans.append(s.charAt(i));
            }  else if (s.charAt(i) >= 48 && s.charAt(i) <= 57){
                // 0-9 -> 48-57
                ans.append(s.charAt(i));
            } else {
                break;
            }
        }

        // if ans is empty return 0
        if (ans.isEmpty() || (ans.length() == 1 && (ans.charAt(0) == '+' || ans.charAt(0) == '-'))){
            return 0;
        }

        // filter the leading zeros in ans
        StringBuilder filteredAns = new StringBuilder();
        for (int i = 0; i < ans.length(); i++) {
            if ((filteredAns.isEmpty() && ans.charAt(i) == 48) ||
                    (filteredAns.length() == 1 && (filteredAns.charAt(0) == '+' || filteredAns.charAt(0) == '-') && ans.charAt(i) == 48)){
                continue;
            }

            filteredAns.append(ans.charAt(i));
        }

        if (filteredAns.isEmpty() || (filteredAns.length() == 1 && (filteredAns.charAt(0) == '+' || filteredAns.charAt(0) == '-'))){
            return 0;
        }

        // checking if the ans is overflowed integer value
        int lengthOfAns = filteredAns.length();
        boolean isPositive = filteredAns.charAt(0) == '+';
        boolean isNegative = filteredAns.charAt(0) == '-';
        lengthOfAns = isPositive || isNegative ? lengthOfAns - 1 : lengthOfAns;

        // length of ans greater than 10 means it exceeded the integer value
        if (lengthOfAns > 10){
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        } else if (lengthOfAns < 10) {
          return Integer.parseInt(ans.toString());
        }

        // if the ans length is equal to 10, and it is overflowed integer value
        long ansValue = Long.parseLong(ans.toString());
        return ansValue < Integer.MIN_VALUE ? Integer.MIN_VALUE : ansValue > Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) ansValue;
        // time: O(n)
        // space: O(n) // for ans
    }

    public int myAtoiTwo(String s) {
        int index = 0;
        boolean isNegative = false;
        double ans = 0;

        // skipping the leading spaces
        while (index < s.length() && s.charAt(index) == ' '){
            index++;
        }

        if (index >= s.length()){
            return 0;
        }
        // determining the sign
        if (s.charAt(index) == '+' || s.charAt(index) == '-'){
            isNegative = s.charAt(index) == '-';
            index++;
        }

        for (; index < s.length(); index++) {
            char ch = s.charAt(index);

            if (!Character.isDigit(ch)){
                break;
            }
            ans = ans * 10 + (int) ch - '0';
        }

        ans = isNegative ? -ans : ans;

        // check for overflow
        if (ans > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;

        if (ans < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;

        return (int) ans;
        // time: O(n)
        // space: O(1)
    }

    public static void main(String[] args) {
//        System.out.println(Integer.MAX_VALUE); // 2147483647
//        System.out.println(Integer.MIN_VALUE); // -2147483648
//        System.out.println(Integer.parseInt("2147483649"));
        System.out.println(new StringToIntegerAtoI().myAtoi("  0000000000012345678"));
    }
}
