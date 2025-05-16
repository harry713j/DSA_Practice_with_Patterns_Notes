package linkedlist.leetcode.medium;

// https://leetcode.com/problems/delete-node-in-a-linked-list/
public class DeleteNode {
    public void deleteNode(ListNode node) {
        // as the node is not the tail node, we can update value of the node by its next node's value
        // and point node's next pointer to node's next node's next node
        ListNode temp = node.next;
        node.val = temp.val;
        node.next = temp.next;
        // time: O(1)
        // space: O(1)
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
}
