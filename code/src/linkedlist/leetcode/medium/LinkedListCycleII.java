package linkedlist.leetcode.medium;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/linked-list-cycle-ii/
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        // brute-force: using set data structure, we will insert the nodes to the set if there is a node already present in the
        // set then that is the starting node of the cycle otherwise cycle is not present
        if (head == null){
            return null;
        }

        ListNode temp = head;
        Set<ListNode> set = new HashSet<>();

        while (temp != null){
            if (set.contains(temp)){
                return temp;
            }
            set.add(temp);
            temp = temp.next;
        }

        // no cycle
        return null;
        // time: O(n)
        // space: O(n)
    }

    public ListNode detectCycleTwo(ListNode head) {
        // optimal: using fast and slow pointer, if there is a cycle then fast and slow will meet at a node, from that node to cycle's start
        // node is at same distance as from head node
        if (head == null){
            return null;
        }

        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                break;
            }
        }

        if (fast == null || fast.next == null){
            // no cycle is present
            return null;
        }
        // start the slow from head again
        slow = head;
        // they will meet at start node of the cycle
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
        // time: O(n)
        // space: O(1)
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
