package linkedlist.leetcode.easy;

// https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // this is a dummy because we are not checking if list1 or list2 is null
        ListNode dummyHead = new ListNode();
        ListNode pointer = dummyHead;

        while (list1 != null && list2 != null){
            if (list1.val < list2.val){
                pointer.next = list1;
                list1 = list1.next;
            } else{
                pointer.next = list2;
                list2 = list2.next;
            }
            pointer = pointer.next;
        }

        pointer.next = (list1 == null) ? list2 : list1;
        return dummyHead.next;
        // Time: O(m+n)
        // Space: O(1)
    }

    public ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        // if list1 is null then we will return the list2
        if (list1 == null){
            return list2;
        }
        // otherwise if list2 is null then we will return the list1
        if (list2 == null){
            return list1;
        }

        // if list1 value is less than list2 then we will make the list1's next node calculated value
        // of list1.next and list2 and vice versa
        if (list1.val < list2.val){
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else{
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
        // Time: O(m+n)
        // Space: O(m+n)
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
