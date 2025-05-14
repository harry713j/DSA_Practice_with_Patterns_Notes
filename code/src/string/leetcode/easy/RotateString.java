package string.leetcode.easy;

import java.util.Arrays;

// https://leetcode.com/problems/rotate-string/
public class RotateString {
    public boolean rotateString(String s, String goal) {
        // brute-force: rotate the original string and compare both
        if(s.length() != goal.length()){
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            // compare s and goal
            int j = 0;
            while (j < s.length()){
                if (s.charAt(j) != goal.charAt(j)){
                    break;
                }
                j++;
            }

            if (j == s.length()){
                return true;
            }

            // rotate the string right to left by one
            s = rotate(s);
        }

        return false;
        // time: O(n ^ 2)
        // space: O(n)
    }

    private String rotate(String s) {
        char[] res = s.toCharArray();
        char last = s.charAt(s.length() - 1);

        for (int i = 0; i < res.length - 1; i++) {
            // shift the characters
            res[res.length - 1 - i] = res[res.length - 2 - i];
        }
        res[0] = last;
        return new String(res);
    }

    public boolean rotateStringTwo(String s, String goal) {
        // optimal: KMP algorithms
        return s.length() == goal.length() && (s + s).contains(goal);
        // time: O(n)
        // space: O(n)
    }

    public static void main(String[] args) {
        System.out.println(new RotateString().rotateString("abcad", "adabc"));
    }
}
