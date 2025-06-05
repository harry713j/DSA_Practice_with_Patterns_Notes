package stack.leetcode.easy;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == ')' || c == '}' || c == ']'){
                if (!stack.empty() && ((c == ')' && stack.peek() == '(') ||
                        (c == '}' && stack.peek() == '{' || (c == ']' && stack.peek() == '[') ) )){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(c);
            }

        }

        return stack.empty();
        // time: O(n)
        // space: O(n)
    }
}
