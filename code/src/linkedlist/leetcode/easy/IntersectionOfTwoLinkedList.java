package linkedlist.leetcode.easy;

public class IntersectionOfTwoLinkedList {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        int l1 = 0, l2 = 0;
        // calculating length of first list
        while (p != null){
            l1++;
            p = p.next;
        }

        while (q != null){
            l2++;
            q = q.next;
        }

        p = headA; q = headB;

        if (l1 > l2){
            for (int i = 0; i < l1 - l2; i++) {
                p = p.next;
            }
        } else {
            for (int i = 0; i < l2 - l1; i++) {
                q = q.next;
            }
        }

        while (p != null && q != null){
            if (p == q){
                return p;
            }
            p = p.next;
            q = q.next;
        }

        return null;
        // Time: O(n)
        // Space: O(1)
    }

    public ListNode getIntersectionNodeTwo(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }

        ListNode p = headA;
        ListNode q = headB;

        // if we traverse through total of len(headA) + len(headB) for each pointer
        // at one point they will be pointing at the same node or null
        while (p != q){
            p = p == null ? headB : p.next;
            q = q == null ? headA : q.next;
        }

        return p;
        // Time: O(n)
        // Space: O(1)
    }

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
