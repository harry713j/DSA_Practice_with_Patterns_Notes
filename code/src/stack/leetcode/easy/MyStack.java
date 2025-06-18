package stack.leetcode.easy;

import java.util.ArrayDeque;
import java.util.Queue;

// Implementation stack using queue
// https://leetcode.com/problems/implement-stack-using-queues/
public class MyStack {
    private Queue<Integer> queue;

    public MyStack() {
        this.queue = new ArrayDeque<>();
    }

    public void push(int x) {
        queue.add(x);
        int size = queue.size();

        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.peek());
            // remove
            queue.remove();
        }

        // time: O(n)
    }

    public int pop() {
        return queue.remove();
        // time: O(1)
    }

    public int top() {
        return queue.peek();
        // time: O(1)
    }

    public boolean empty() {
        return queue.isEmpty();
        // time: O(1)
    }
}
