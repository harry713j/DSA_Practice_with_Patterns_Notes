package string.leetcode.easy;

// https://leetcode.com/problems/roman-to-integer/
public class RomanToInteger {
    public int romanToInt(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        int[] values = new int[91];
        values['I'] = 1;
        values['V'] = 5;
        values['X'] = 10;
        values['L'] = 50;
        values['C'] = 100;
        values['D'] = 500;
        values['M'] = 1000;

        int total = 0;
        for (int i = 1; i < s.length(); i++) {
            if (values[s.charAt(i)] > values[s.charAt(i - 1)]) {
                total = total - values[s.charAt(i - 1)];
            } else {
                total = total + values[s.charAt(i - 1)];
            }
        }

        return total + values[s.charAt(s.length() - 1)];
        // time: O(n)
        // space: O(1)
    }
}
