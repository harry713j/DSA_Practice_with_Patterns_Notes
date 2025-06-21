package slidingWindow_twoPointers.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // brute-force
        Map<Character, Integer> freq = new HashMap<>();
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);

                if (!freq.containsKey(c)){
                    freq.put(c, j);
                } else {
                    maxLength = Math.max(maxLength, j - i);
                    freq.clear();
                    break;
                }
            }
            // if there is still non-identical characters
            if (!freq.isEmpty()){
                maxLength = Math.max(maxLength, s.length() - i);
            }
        }

        return maxLength;
        // time: O(n * k) , k is max length without repeating characters (in worst case k = n)
        // space: O(k)
    }

    public int lengthOfLongestSubstringTwo(String s) {
        // optimal: Sliding window
        Map<Character, Integer> freq = new HashMap<>();
        int maxLength = 0;
        int left = 0, right = 0;

        while (right < s.length()){
            char character = s.charAt(right);

            if (freq.containsKey(character)){
                if (freq.get(character) >= left)
                    left = freq.get(character) + 1;
            }

            maxLength = Math.max(maxLength, right - left + 1);

            freq.put(character, right);
            right++;
        }

        return maxLength;
        // time: O(n)
        // space: O(n)
    }

    public static void main(String[] args) {
        String s = "cdbzabcd";
        System.out.println(new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstringTwo(s));
    }
}
