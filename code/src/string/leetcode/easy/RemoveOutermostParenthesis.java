package string.leetcode.easy;

import java.util.Stack;

// https://leetcode.com/problems/remove-outermost-parentheses/
public class RemoveOutermostParenthesis {
    public String removeOuterParentheses(String s) {
        // using two pointer and stack we will check the valid parenthesis string and remove the outermost parenthesis
        int i = 0, j = 0;
        StringBuilder ans = new StringBuilder();
        Stack<Character> stack = new Stack<>(); // stack for checking the validness

        while (j < s.length()){
            // if string character is ')' then we pop from stack
            if (s.charAt(j) == ')'){
                stack.pop();
            } else {
                stack.push(s.charAt(j));
            }
            // if the stack is empty and j > 0 means we have a valid parenthesis string
            if (stack.isEmpty()){
                ans.append(s, i + 1, j);
                i = j + 1;
            }
            j++;
        }

        return ans.toString();
        // time: O(n)
        // space: O(n)
    }

    public String removeOuterParenthesesTwo(String s) {
        // space optimized:
        // using a variable to track if the character is '(' then we will increment it if character is ')' then we will decrement it
        int opened = 0;
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            // if opened is greater than 0 means we ignored the outer parenthesis
            if (s.charAt(i) == '(' && opened++ > 0){
                ans.append(s.charAt(i));
            }

            if (s.charAt(i) == ')' && opened-- > 1){
                ans.append(s.charAt(i));
            }
        }

        return ans.toString();
        // time: O(n)
        // space: O(1)
    }

    public static void main(String[] args) {
        String s = "(()())(())(()(()))";
        System.out.println(new RemoveOutermostParenthesis().removeOuterParentheses(s));
    }
}
