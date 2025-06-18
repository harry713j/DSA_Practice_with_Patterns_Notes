package stack.impl;

import java.util.Stack;

public class PrefixInfixPostfix {

    private static String reverse(String s){
        char[] chars = s.toCharArray();
        int i = 0, j = chars.length - 1;

        while (i <= j){
            char t = chars[i];
            chars[i] = chars[j];
            chars[j] = t;

            i++;
            j--;
        }

        // changing brackets ( to ) and vice-versa
        for (int k = 0; k < chars.length; k++) {
            if (chars[k] == '('){
                chars[k] = ')';
            } else if (chars[k] == ')') {
                chars[k] = '(';
            }
        }

        return new String(chars);
    }

    private static int priority(char c){
        return switch (c) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public static String infixToPostfix(String s){
        // infix: (a+b) * (c-d)
        int i = 0;
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        
        while (i < s.length()){
            char c = s.charAt(i);
            
            if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9')){
                ans.append(c);
            } else if (c == '(') {
                st.push(c);
            } else if (c == ')') {
                // pop out the operator till ( and append to the ans
                while (!st.empty() && st.peek() != '('){
                    ans.append(st.peek());
                    st.pop();
                }
                // pop out the (
                st.pop();
            } else {
                // if the operator encountered
                while (!st.empty() && priority(c) <= priority(st.peek())){
                    ans.append(st.peek());
                    st.pop();
                }
                // push the low priority operator
                st.push(c);
            }
            i++;
        }

        // if stack still has the operators
        while (!st.empty()){
            ans.append(st.peek());
            st.pop();
        }

        return ans.toString();
        // time: O(n) + O(n)
        // space: O(n) + O(n)
    }

    public static String infixToPrefix(String s){
        // 1. reverse the expression
        // 2. do a controlled postfix conversion
        // 3. reverse the ans
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        s = reverse(s);

        for (int i = 0; i < s.length(); i++) {
           char c = s.charAt(i);

            if (Character.isLetterOrDigit(c)){
                ans.append(c);
            } else if (c == '('){
                st.push(c);
            } else if (c == ')') {
                // pop out the operator till ( and append to the ans
                while (!st.empty() && st.peek() != '('){
                    ans.append(st.peek());
                    st.pop();
                }
                // pop out the (
                st.pop();
            } else {
                // if the operator encountered
                while (!st.empty() && priority(c) < priority(st.peek())){
                    ans.append(st.peek());
                    st.pop();
                }
                // push the low priority operator
                st.push(c);
            }
        }

        // if the stack still not empty
        while (!st.empty()){
            ans.append(st.peek());
            st.pop();
        }

        return ans.reverse().toString();
        // time: O(n) + O(n)
        // space: O(n) + O(n)
    }

    public static String postfixToInfix(String expression){
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            } else {
                // if it is an operator then pop out two element from stack
                String e1 = stack.pop();
                String e2 = stack.pop();

                stack.push( "(" + e2 + c + e1 + ")");
            }
        }

        return stack.pop();
        // time: O(n)
        // space: O(n)
    }

    public static String prefixToInfix(String expression){
        Stack<String> stack = new Stack<>();

        for (int i = expression.length() - 1; i >= 0; i--) {
            char c = expression.charAt(i);

            if (Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            } else {
                // if it is an operator then pop out two element from stack
                String e1 = stack.pop();
                String e2 = stack.pop();

                stack.push( "(" + e1 + c + e2 + ")");
            }
        }

        return stack.pop();
        // time: O(n)
        // space: O(n)
    }

    public static String postfixToPrefix(String exp){
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < exp.length(); i++) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            } else {
                // if it is an operator
                String e1 = stack.pop();
                String e2 = stack.pop();

                stack.push(c + e2 + e1);
            }
        }

        return stack.pop();
        // time: O(n)
        // space: O(n)
    }

    public static String prefixToPostfix(String exp){
        Stack<String> stack = new Stack<>();

        for (int i = exp.length() - 1; i >= 0; i--) {
            char c = exp.charAt(i);

            if (Character.isLetterOrDigit(c)){
                stack.push(String.valueOf(c));
            } else {
                // if it is an operator
                String e1 = stack.pop();
                String e2 = stack.pop();

                stack.push(e1 + e2 + c);
            }
        }

        return stack.pop();
        // time: O(n)
        // space: O(n)
    }

    
    public static void main(String[] args) {
        System.out.println(infixToPostfix("(a+b)*(c-d)"));
        System.out.println(infixToPrefix("(a+b)*(c-d)"));
        System.out.println(postfixToInfix("ab+cd-*"));
        System.out.println(prefixToInfix("*+ab-cd"));

        System.out.println(postfixToPrefix("ab+cd-*"));
        System.out.println(prefixToPostfix("*+ab-cd"));

    }
}
