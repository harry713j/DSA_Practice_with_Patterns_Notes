package string.leetcode.easy;

public class MaxNestingDepthOfParenthesis {
    // intuition: we need to count at a time how many opening parenthesis are there without any closing parenthesis
    public int maxDepth(String s) {
        int max = 0, count = 0;
        // if the character is '(' we will increase the count, if ')" we will decrease the count otherwise ignore
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                count++;
            } else if (s.charAt(i) == ')') {
                count--;
            }
            // updating the max at each iteration
            max = Math.max(max, count);
        }

        return max;
        // time: O(n)
        // space: O(1)
    }
}
