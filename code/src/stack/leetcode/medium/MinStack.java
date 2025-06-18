package stack.leetcode.medium;

// https://leetcode.com/problems/min-stack/
// https://takeuforward.org/data-structure/implement-min-stack-o2n-and-on-space-complexity/
public class MinStack {

    private Node head;

    public void push(int val) {
        if (head == null)
            head = new Node(val, val, null);
        else
            head = new Node(val, Math.min(val, head.minTillNow), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.minTillNow;
    }

    private static class Node {
        private int val;
        private int minTillNow;
        private Node next;

        private Node(int val, int min, Node next) {
            this.val = val;
            this.minTillNow = min;
            this.next = next;
        }
    }
}
