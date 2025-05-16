package linkedlist.leetcode.medium;

//https://leetcode.com/problems/odd-even-linked-list/
public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        // intuition: we need two separate head for odd and even position nodes, and keep a counter for identifying the position.
        if (head == null){
            return null;
        }

        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode curr = head;

        ListNode odd = oddHead, even = evenHead;
        int counter = 1;

        while (curr != null){
            if (counter % 2 == 0){
                even.next = curr;
                even = even.next;
            } else {
                odd.next = curr;
                odd = odd.next;
            }
            counter++;
            curr = curr.next;
        }

        // merge two
        even.next = null;
        odd.next = evenHead.next;

        return oddHead.next;
        // time: O(n)
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
