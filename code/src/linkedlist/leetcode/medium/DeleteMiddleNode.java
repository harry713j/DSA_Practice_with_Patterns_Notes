package linkedlist.leetcode.medium;

// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/
public class DeleteMiddleNode {
    public ListNode deleteMiddle(ListNode head) {
        // brute-force: find the length of the linked list, then move a pointer to the middle and delete the middle node
        if (head == null || head.next == null){
            return null;
        }
        ListNode temp = head;
        int length = 0;

        while (temp != null){
            length++;
            temp = temp.next;
        }
        // move to the middle node
        ListNode prev = null;
        temp = head;

        for (int i = 0; i < length / 2; i++) {
            prev = temp;
            temp = temp.next;
        }
        // change the links
        if (prev != null){
            prev.next = temp.next;
        }
        temp.next = null;

        return head;
        // time: O(n)
        // space: O(1)
    }

    public ListNode deleteMiddleTwo(ListNode head) {
        // optimal: using fast and slow pointer i.e. with single pass
        if (head == null || head.next == null){
            return null;
        }

        ListNode slow = head, fast = head, prev = null;
        // find the middle node
        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // change the links
        prev.next = slow.next;
        slow.next = null;

        return head;
        // time : O(n)
        // space: O(1)
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
