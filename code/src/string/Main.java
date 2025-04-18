package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    static int length(String str) {
        /*
        * Time complexity - O(n)
        * Space complexity - O(n)
        * */
        if (str.equals("")) {
            return 0;
        }
        return length(str.substring(1)) + 1;
    }

    static String changeCase(String str){
        /*
         * Time complexity - O(n)
         * Space complexity - O(n)
         * */
        if (str.equals("")) {
            return "";
        }

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= 65 && str.charAt(i) <= 90){
                res.append((char) (str.charAt(i) + 32));
            } else if (str.charAt(i) >= 97 && str.charAt(i) <= 122) {
                res.append((char) (str.charAt(i) - 32));
            } else {
                res.append(str.charAt(i));
            }
        }

        return res.toString();
    }

    static String reverse(String str){
        /*
         * Time complexity - O(n)
         * Space complexity - O(n)
         * */
        if (str.equals("")){
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            result.append(str.charAt(str.length() - 1 - i));
        }

        return result.toString();
    }

    static boolean isPalindrome(String str){
        /*
         * Time complexity - O(n)
         * Space complexity - O(1)
         * */
        int i = 0, j = str.length() - 1;

        while (i < j){
            if (str.charAt(i) != str.charAt(j)){
                return false;
            }

            i++; j--;
        }

        return true;
    }

    static void findDuplicate(String str){
        /*
         * Time complexity - O(n)
         * Space complexity - O(n)
         * */
        if (str.isEmpty()){
            System.out.println("String is empty");
            return;
        }

        if (str.length() == 1){
            System.out.println("No duplicate found!");
            return;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        boolean flag = true;

        for(Map.Entry<Character, Integer> entry : map.entrySet()){
            if (entry.getValue() > 1){
                flag = false;
                System.out.println(entry.getKey() + " -> " + entry.getValue());
            }
        }

        if (flag){
            System.out.println("No duplicate found!");
        }

    }

    static void findDuplicatesUsingBitwise(String str){
        // This function will work if the string contains only alphabets
        /*
         * Time complexity - O(n)
         * Space complexity - O(1)
         * */
        if (str.isEmpty()){
            System.out.println("String is empty");
            return;
        }

        if (str.length() == 1){
            System.out.println("No duplicate found!");
            return;
        }

        int h = 0, x = 0;
        boolean flag = true;

        for (int i = 0; i < str.length(); i++) {
            x = 1;
            x = x << (str.charAt(i) - 64);

            if ((x & h) > 0){
                flag = false;
                System.out.println(str.charAt(i) + " is duplicated");
            } else {
                h = h | x;
            }

        }

        if (flag){
            System.out.println("No duplicate found");
        }
    }

    static boolean checkAnagram(String str1, String str2){
        /*
         * Time complexity - O(n)
         * Space complexity - O(1)
         * */
        if (str1.length() != str2.length()){
            return false;
        }

        int[] count = new int[26];

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);

            count[ch - 'a']++;
        }

        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);

            if (count[ch - 'a'] == 0){
                return false;
            }

            count[ch - 'a']--;
        }

        return true;

    }

    // Permutation
    static List<String> permutationOne(String str){
        // Back-Tracking
        /*
         * Time complexity - O(n * n!)
         * Space complexity - O(n)
         * */
        List<String> ans = new ArrayList<>();
        boolean[] flag = new boolean[str.length()];
        StringBuilder res = new StringBuilder();
        permutationOne(str, res, ans, flag);
        return ans;
    }

    private static void permutationOne(String str, StringBuilder res, List<String> ans, boolean[] flag){
        if (res.length() == str.length()){
            ans.add(res.toString());
            return;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (!flag[i]){
                    flag[i] = true;
                    res.append(str.charAt(i));
                    permutationOne(str, res, ans, flag);
                    flag[i] = false;
                    res.deleteCharAt(res.length() - 1);
                }

            }
        }
    }

    public static void main(String[] args) {
        // IMP: String is immutable in java we can't modify it
//        System.out.println(length("hello there"));
//        System.out.println(changeCase("HelLO"));
//        System.out.println(reverse("hello"));
//        System.out.println(isPalindrome(""));
//        findDuplicate("baba black sheep");
//        findDuplicatesUsingBitwise("hell");
//        System.out.println(checkAnagram("anagram", "aargana"));
        for (String s: permutationOne("abca")){
            System.out.println(s);
        }


    }
}
