package string.leetcode.medium;

import java.util.Stack;
import java.util.StringTokenizer;

// https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWords {
    public String reverseWords(String s) {
        Stack<String> stack = new Stack<>(); // for storing the words
        StringBuilder ans = new StringBuilder(); // will hold the ans

        int i = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == ' '){
                i++;
            }
            else if ((j < s.length() - 1 && s.charAt(j + 1) == ' ') || j == s.length() - 1){
                stack.push(s.substring(i, j + 1));
                i = j + 1;
            }
        }

        // adding the words to the ans
       while (!stack.empty()){
           if (stack.size() == 1){
               ans.append(stack.pop());
           } else {
               ans.append(stack.pop()).append(" ");
           }
       }

        return ans.toString();
        // time: O(n)
        // space: O(n)
    }

    // we can use StringTokenizer class also

    public static void main(String[] args) {
        String s = "  hello world  ";
        System.out.println(new ReverseWords().reverseWords(s));
    }
}
