package linkedlist.leetcode.easy;

// https://leetcode.com/problems/remove-linked-list-elements/
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return null;
        }

        ListNode first = head;
        ListNode second = null;

        while (first != null){
            if (first.val == val && first == head){
                head = head.next;
                first.next = null;
                first = head;
            } else if (first.val == val) {
                second.next = first.next;
                first = first.next;
            } else {
                second = first;
                first = first.next;
            }
        }

        return head;
        // Time: O(n)
        // Space: O(1)
    }

    public ListNode removeElementsTwo(ListNode head, int val) {
        // https://leetcode.com/problems/remove-linked-list-elements/solutions/1572932/java-three-simple-clean-solutions-w-explanation-iterative-recursive-beats-100/
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode cur = dummy;

        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
                // Here cannot move cur to cur.next as we need to validate the next node.
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
        // Time: O(n)
        // Space: O(1)
    }

    /*
    *   In this solution, removeElements function returns the head of the solved list (nodes with val are removed).
        Once we get the solved rightSideHead from the recursion call, rightSideHead node will point to the solved list.
        Now, we have two choices:

        If head.val == val --> Current node needs to be removed, so return the rightSideHead as it points to the solved right side list.
        If head.val != val --> Update the next pointer of current list, as the next node might have been removed. And then return the current
        node.
        Time Complexity: O(N) --> Each Node in the list is visited once.
        Space Complexity: O(N) --> Recursion Stack space
        Where, N = Length of the input list.
* */
    public ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        // Once removeElements call is done, right side of the list is solved.
        ListNode rightSideHead = removeElements(head.next, val);
        if (head.val == val) {
            return rightSideHead;
        }
        head.next = rightSideHead;
        return head;
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
