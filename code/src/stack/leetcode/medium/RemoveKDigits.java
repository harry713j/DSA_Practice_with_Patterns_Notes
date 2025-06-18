package stack.leetcode.medium;

import java.util.Stack;

// https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        // using a stack
        if (k >= num.length()){
            return "0";
        }

        Stack<Character> stack = new Stack<>();

        // only keep smaller digits at first
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);

            while (!stack.empty() && k > 0 && stack.peek() - '0' > c - '0'){
                stack.pop();
                k--;
            }

            stack.push(c);
        }

        // if k > 0
        while (k > 0){
            stack.pop();
            k--;
        }

        // retrieve the answer
        StringBuilder ans = new StringBuilder();

        while (!stack.empty()){
            ans.append(stack.pop());
        }

        // remove the zeros from back
        while (!ans.isEmpty() && ans.charAt(ans.length() - 1) == '0'){
            ans.deleteCharAt(ans.length() - 1);
        }

        if (ans.isEmpty())
            return "0";

        return ans.reverse().toString();
        // time: O(n)
        // space: O(n)
    }

    // we can do that with List too
}
