package string.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/valid-anagram/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        // brute-force: sort the strings and compare
        if (s.length() != t.length()){
            return false;
        }

        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();

        Arrays.sort(charS);
        Arrays.sort(charT);

        for (int i = 0; i < charS.length; i++) {
            if (charS[i] != charT[i]){
                return false;
            }
        }

        return true;
        // time: O(n * log n)
        // space: O(n)
    }

    public boolean isAnagramTwo(String s, String t) {
        // optimal: using hash table or hash array
        if (s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequency.put(ch, frequency.getOrDefault(ch, 0) + 1);
        }

        // check all the characters are in t
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (!frequency.containsKey(ch) || frequency.get(ch) == 0){
                return false;
            } else {
                // reduce the count
                frequency.put(ch, frequency.get(ch) - 1);
            }
        }

        return true;
        // time: O(n)
        // space: O(n)
    }

    public boolean isAnagramThree(String s, String t) {
        // optimal : using a hash array
        if (s.length() != t.length()){
            return false;
        }

        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            count[ch - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (count[ch - 'a'] == 0){
                return false;
            } else {
                count[ch - 'a']--;
            }
        }
        return true;
        // time: O(n)
        // space: O(n)
    }

}
