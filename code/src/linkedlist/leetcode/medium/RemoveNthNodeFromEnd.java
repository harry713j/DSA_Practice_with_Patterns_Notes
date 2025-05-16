package linkedlist.leetcode.medium;

public class RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // brute-force
        // intuition: count the number of node and traverse to that node to be deleted;
        if (head == null){
            return null;
        }
        int nodeCounter = 0;
        ListNode curr = head;

        while (curr != null){
            nodeCounter++;
            curr = curr.next;
        }

        if (nodeCounter == n){
            // i.e. the head element
            head = head.next;
            return head;
        }

        curr = head;
        ListNode prev = null;

        for (int i = 0; i < nodeCounter - n; i++) {
            prev = curr;
            curr = curr.next;
        }

        // change the links
        if (prev != null) {
            prev.next = curr.next;
        }

        return head;
        // time: O(n)
        // space: O(1)
    }

    public ListNode removeNthFromEndTwo(ListNode head, int n) {
        // optimal:  fast pointer and a slow pointer. The fast-moving pointer will initially be exactly N nodes
        // ahead of the slow-moving pointer. After which, both of them will move one step at a time. When the fast pointer
        // reaches the last node, i.e., the L-th node, the slow is guaranteed to be at the (L-N)-th node, where L is the total
        // length of the linked list.
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast == null){
            return head.next;
        }
        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }

    class ListNode {
       int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
