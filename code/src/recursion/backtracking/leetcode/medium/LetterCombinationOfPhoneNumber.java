package recursion.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationOfPhoneNumber {
    // brute-force: Using a hashmap, map 2-9 numbers with their string alphabets,
    // in the nested loop create the result string and add it to ans

    private static final Map<Character, String> digitToChar = new HashMap<>();
    static {
        digitToChar.put('2', "abc");
        digitToChar.put('3', "def");
        digitToChar.put('4', "ghi");
        digitToChar.put('5', "jkl");
        digitToChar.put('6', "mno");
        digitToChar.put('7', "pqrs");
        digitToChar.put('8', "tuv");
        digitToChar.put('9', "wxyz");
    }


    public List<String> letterCombinations(String digits) {
        // using  back-tracking
        List<String> ans = new ArrayList<>();

        if (digits.isEmpty()){
            return ans;
        }

        backtrack(0, digits, new StringBuilder(), ans);

        return ans;
        // time: O(4^n)
        // space: O(4^n)
    }

    private void backtrack(int index, String digits, StringBuilder currentStr, List<String> ans) {
        if (index == digits.length()){
            ans.add(currentStr.toString());
            return;
        }

        String letter = digitToChar.get(digits.charAt(index));

        for (char ch: letter.toCharArray()){
            currentStr.append(ch);
            backtrack(index + 1, digits, currentStr, ans);
            currentStr.deleteCharAt(currentStr.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> ans = new LetterCombinationOfPhoneNumber().letterCombinations("23");

        System.out.println(ans);
    }
}
