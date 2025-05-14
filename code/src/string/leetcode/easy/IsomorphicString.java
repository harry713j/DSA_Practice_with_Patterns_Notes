package string.leetcode.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/isomorphic-strings/
public class IsomorphicString {
    public boolean isIsomorphic(String s, String t) {
        // using two map
        Map<Character, Character> st = new HashMap<>();
        Map<Character, Character> ts = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch1 = s.charAt(i), ch2 = t.charAt(i);

            // if the characters exists in the map and have different mapped value than current return false
            if ((st.containsKey(ch1) && st.get(ch1) != ch2) || (ts.containsKey(ch2) && ts.get(ch2) != ch1)){
                return false;
            }

            st.put(ch1, ch2);
            ts.put(ch2, ch1);

        }

        return true;
        // time: O(n)
        // space: O(n)
    }

    public boolean isIsomorphicTwo(String s, String t) {
        // using two array for mapping
        int[] map1 = new int[200];
        int[] map2 = new int[200];

        if (s.length() != t.length())
            return false;


        for (int i = 0; i < s.length(); i++) {
            if (map1[s.charAt(i)] != map2[t.charAt(i)])
                return false;

            map1[s.charAt(i)] = i + 1;
            map2[t.charAt(i)] = i + 1;
        }
        return true;
        // time: O(n)
        // space: O(1)
    }

    public static void main(String[] args) {
        System.out.println(new IsomorphicString().isIsomorphicTwo("paper", "title"));
    }
}
