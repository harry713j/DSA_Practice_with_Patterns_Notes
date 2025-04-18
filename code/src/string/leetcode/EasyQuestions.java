package string.leetcode;

import java.util.*;

public class EasyQuestions {

    static String defangIPaddr(String address) {
    // https://leetcode.com/problems/defanging-an-ip-address/
        /*
        * Time Complexity - O(n)
        * Space Complexity - O(n)
        * */
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < address.length(); i++){
            if (address.charAt(i) == '.') {
                ans.append("[.]");
            } else {
                ans.append(address.charAt(i));
            }
        }

        return ans.toString();
    }

    static String restoreString(String s, int[] indices) {
    // https://leetcode.com/problems/shuffle-string/
        if(s.length() == 1){
            return s;
        }

        char[] res = new char[s.length()];

        for(int i = 0; i < s.length(); i++){
            res[indices[i]] = s.charAt(i);
        }

        return String.valueOf(res);
    }

    static boolean isSubsequence(String s, String t) {
    // https://leetcode.com/problems/is-subsequence/
        if (s.length() > t.length()){
            return false;
        }

        if (s.isEmpty()){
            return true;
        }

        int i = 0;

        for(int j = 0; j < t.length(); j++){
            if (s.charAt(i) == t.charAt(j)){
                i++;
            }

            if (i == s.length()){
                break;
            }
        }

        return i >= s.length();
    }

    static boolean isSubsequence2(String s, String t) {
        // https://leetcode.com/problems/is-subsequence/
        // Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109,
        // and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?

//        List<Integer>[] idx = new List[256]; // Just for clarity
//        for (int i = 0; i < t.length(); i++) {
//            if (idx[t.charAt(i)] == null)
//                idx[t.charAt(i)] = new ArrayList<>();
//            idx[t.charAt(i)].add(i);
//        }
//
//        int prev = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (idx[s.charAt(i)] == null) return false; // Note: char of S does NOT exist in T causing NPE
//            int j = Collections.binarySearch(idx[s.charAt(i)], prev);
//            if (j < 0) j = -j - 1;
//            if (j == idx[s.charAt(i)].size()) return false;
//            prev = idx[s.charAt(i)].get(j) + 1;
//        }
//        return true;
        if (s.isEmpty()) return true;

        Map<Character, List<Integer>> charIndices =  new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            charIndices.computeIfAbsent(c, k -> new ArrayList<>()).add(i);
        }

        int prevPos = -1; // Initially, we start before index 0 of `t`

        for (char c : s.toCharArray()) {
            if (!charIndices.containsKey(c)) {
                return false; // Character not in `t` at all
            }
            List<Integer> indices = charIndices.get(c);
            // Find the smallest index in `indices` >= prevPos + 1
            int idx = Collections.binarySearch(indices, prevPos + 1);
            if (idx < 0) {
                idx = -idx - 1; // Convert to insertion point
            }
            if (idx >= indices.size()) {
                return false; // No valid occurrence of `c` after `prevPos`
            }
            prevPos = indices.get(idx); // Move to this position in `t`
        }
        return true;
    }

    static boolean isPalindrome(String s) {
    // https://leetcode.com/problems/valid-palindrome/
//        if (s.isEmpty()){
//            return true;
//        }
//
//        int i = 0, j = s.length() - 1;
//
//
//        while (i < j){
//            char left = Character.toLowerCase(s.charAt(i));
//            char right = Character.toLowerCase(s.charAt(j));
//
//            if (!Character.isLetterOrDigit(left)){
//                i++;
//            } else if (!Character.isLetterOrDigit(right)){
//                j--;
//            } else if (left != right) {
//                return false;
//            } else {
//                i++;
//                j--;
//            }
//        }
//
//        return true;

        if (s.isEmpty()){
            return true;
        }

        StringBuilder filtered = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i))){
                filtered.append(Character.toLowerCase(s.charAt(i)));
            }
        }

        String cleaned = filtered.toString();

        int left = 0, right = cleaned.length() - 1;

        while (left < right){
            if (cleaned.charAt(left) != cleaned.charAt(right)){
                return false;
            }

            left++; right--;
        }
        return true;
    }

    public String mergeAlternately(String word1, String word2) {
        // https://leetcode.com/problems/merge-strings-alternately/
        StringBuilder res = new StringBuilder();
        int min = Math.min(word1.length(),word2.length());
        for(int i = 0; i < min;i++){
            res.append(word1.charAt(i)).append(word2.charAt(i));
        }

        res.append(word1.substring(min)).append(word2.substring(min));

        return res.toString();
    }

    static String longestCommonPrefix(String[] strs) {
        // https://leetcode.com/problems/longest-common-prefix/
        if (strs.length == 1){
            return strs[0];
        }

        StringBuilder res = new StringBuilder();
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        for(int i = 0; i < Math.min(first.length(), last.length()); i++){
            if (first.charAt(i) != last.charAt(i)){
                break;
            }
            res.append(first.charAt(i));
        }

        return res.toString();
    }

    static int romanToInt(String s) {
    // https://leetcode.com/problems/roman-to-integer/
        if (s.isEmpty()){
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

        int total =0;
        for (int i = 1; i < s.length(); i++) {
            if (values[s.charAt(i)] > values[s.charAt(i-1)]){
                total = total - values[s.charAt(i-1)];
            } else {
                total = total + values[s.charAt(i-1)];
            }
        }
        return total + values[s.charAt(s.length()-1)];
    }

    public static void main(String[] args) {
//        System.out.println(defangIPaddr("1.1.1.1"));
//        System.out.println(restoreString("codeleet", new int[]{4,5,6,7,0,2,1,3}));
//        System.out.println(isSubsequence2("abc", "jkahcbgdl"));
//        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(romanToInt("IV"));

    }


}
