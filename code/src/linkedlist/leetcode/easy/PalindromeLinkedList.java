package linkedlist.leetcode.easy;

public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null){
            return true;
        }

        ListNode slow = head, fast = head, prev = null;
        // go to the middle of the list
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }

        // slow is at the middle of the list
        // we can reverse the list from there
        ListNode next;
        while (slow != null){
            next = slow.next;
            // change the link
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        fast = head;
        slow = prev;

        while (slow != null){
            if (fast.val != slow.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }

        return true;
        // Time: O(n)
        // Space: O(1)
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
