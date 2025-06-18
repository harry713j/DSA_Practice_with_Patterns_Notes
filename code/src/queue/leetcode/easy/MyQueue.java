package queue.leetcode.easy;

import java.util.Stack;

// https://leetcode.com/problems/implement-queue-using-stacks/
public class MyQueue {
    private Stack<Integer> firstStack;
    private Stack<Integer> secondStack;

    public MyQueue() {
        this.firstStack = new Stack<>();
        this.secondStack = new Stack<>();
    }

    public void push(int x) {
        firstStack.push(x);
        // time: O(1)
    }

    public int pop() {
        if (secondStack.empty() && firstStack.empty()){
            return 0;
        } else if (secondStack.empty()) {
            // move elements to second stack

            while (!firstStack.empty()){
                secondStack.push(firstStack.pop());
            }

            return secondStack.pop();
        } else {
            return secondStack.pop();
        }

        // time: O(n) amortized O(1)
    }

    public int peek() {
        if (secondStack.empty() && firstStack.empty()){
            return 0;
        } else if (secondStack.empty()) {
            // move elements to second stack
            while (!firstStack.empty()) {
                secondStack.push(firstStack.pop());
            }

            return secondStack.peek();
        } else {
            return secondStack.peek();
        }

        // time: O(n) amortized O(1)
    }

    public boolean empty() {
        return firstStack.empty() && secondStack.empty();
        // time: O(1)
    }
}
