package linkedlist.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/linked-list-cycle/
public class LinkedListCycleDetection {
    public boolean hasCycle(ListNode head) {
        // brute-force
        if (head == null || head.next == null){
            return false;
        }

        Set<ListNode> visited = new HashSet<>();
        ListNode curr = head;

        while (curr != null){
            if (visited.contains(curr)){
                // we have the cycle
                return true;
            }
            visited.add(curr);
            curr = curr.next;
        }

        return false;
        // Time: O(n)
        // Space: O(n)
    }

    public boolean hasCycleTwo(ListNode head) {
        // fast & slow pointer
        if (head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                return true;
            }
        }

        return false;
        // Time: O(n)
        // Space: O(1)
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











