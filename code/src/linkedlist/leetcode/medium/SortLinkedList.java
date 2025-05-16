package linkedlist.leetcode.medium;

// https://leetcode.com/problems/sort-list/
public class SortLinkedList {
    // brute-force: using an array, traverse the linked list and put elements to the array, then sort the array and
    // make a new linked list from the sorted array and return the head;

    public ListNode sortList(ListNode head){
        // optimal: merge sort mechanism, divide the array into two halves, sort both halves and then merge it
        if (head == null || head.next == null){
            return head;
        }

        ListNode slow = head, fast = head, prev = null;

        while (fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null;
        // sort two halves separately
        head = sortList(head);
        slow = sortList(slow);

        // merge two halves
        return merge(head, slow);
        // time: O(n log n)
        // space: O(log n)
    }

    private ListNode merge(ListNode first, ListNode second){
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while (first != null && second != null){
            if (first.val < second.val){
                temp.next = first;
                first = first.next;
            } else {
                temp.next = second;
                second = second.next;
            }
            temp = temp.next;
        }
        // remaining nodes in either list
        temp.next = first != null ? first : second;

        return dummy.next;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
