package linkedlist.leetcode.easy;

// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
public class RemoveDuplicateFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        while (second != null){
            if (first.val == second.val) {
                first.next = second.next;
            } else {
                first = first.next;
            }
            second = second.next;
        }

        return head;
        // Time: O(n)
        // Space: O(1)
    }

    public ListNode deleteDuplicatesTwo(ListNode head) {
        ListNode dummy = head;
        if(head == null){
            return null;
        }
        while (dummy.next != null){
            if (dummy.val == dummy.next.val){
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }
        return head;
        // Time: O(n)
        // Space: O(1)
    }

    public ListNode deleteDuplicatesRecursive(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }

        head.next = deleteDuplicatesRecursive(head.next);
        return head.val == head.next.val ? head.next : head;
        // Time: O(n)
        // Space: O(n)
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
