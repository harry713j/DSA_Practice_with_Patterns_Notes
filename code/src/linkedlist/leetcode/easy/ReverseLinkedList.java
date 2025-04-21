package linkedlist.leetcode.easy;

// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode next = null;

        while (head != null){
            next = head.next;
            // change the link
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
        // Time: O(n)
        // Space: O(1)
    }

    public ListNode reverseListRecursive(ListNode head) {
        return reverseListRecursive(head, null);
    }

    public ListNode reverseListRecursive(ListNode head, ListNode prev) {
        if (head == null) {
            return prev;
        }

        ListNode next = head.next;
        head.next = prev;
        return reverseListRecursive(next, head);
        // Time: O(n)
        // Space: O(n)
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
