package string.leetcode.easy;

import java.util.Arrays;

public class LongestCommonPrefix {
    // brute-force: compare each strings one by one and find the common
    private String MatchingPattern(String str1, String str2){
        if(str1.isEmpty() || str2.isEmpty()){
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int n = Math.min(str1.length(), str2.length());

        for(int i = 0; i < n; i++){
            if(str1.charAt(i) == str2.charAt(i)){
                sb.append(str1.charAt(i));
            } else {
                break;
            }
        }

        return sb.toString();
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 1){
            return strs[0];
        }

        String res = strs[0];

        for(int i = 1; i < strs.length; i++){
            res = MatchingPattern(res, strs[i]);

            if(res.isEmpty()){
                return res;
            }
        }

        return res;
        // time: O(n * length of largest string)
        // space: O(1)
    }

    public String longestCommonPrefixTwo(String[] strs) {
        // optimal: sort the array
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
        // time: O(n)
        // space: O(1)
    }
}
