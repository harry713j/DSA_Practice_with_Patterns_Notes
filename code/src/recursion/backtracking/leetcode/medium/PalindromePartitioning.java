package recursion.backtracking.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        // back-tracking
        List<List<String>> ans = new ArrayList<>();
        partitionHelper(s, 0, new ArrayList<>(), ans);

        return ans;
        // time: O(n * 2^n)
        // space: O(n * 2^n)
    }

    private void partitionHelper(String s, int index, List<String> ds, List<List<String>> ans) {
        if (index == s.length()){
            ans.add(new ArrayList<>(ds));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            // if the substring is palindrome then we will proceed
            if (isPalindrome(s, index, i)){
                ds.add(s.substring(index, i + 1));
                partitionHelper(s, i + 1, ds, ans);
                ds.remove(ds.size() - 1);
            }
        }
        
    }

    private boolean isPalindrome(String s, int start, int end){
        while (start <= end){
            if (s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> ans = new PalindromePartitioning().partition("aabb");
        for (List<String> a : ans){
            System.out.println(a);
        }
    }
}
