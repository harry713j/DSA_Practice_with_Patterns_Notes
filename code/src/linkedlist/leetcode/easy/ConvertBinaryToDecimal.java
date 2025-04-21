package linkedlist.leetcode.easy;

// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/

public class ConvertBinaryToDecimal {
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }

        StringBuilder binNum = new StringBuilder();
        while (head != null) {
            binNum.append(head.val);
            head = head.next;
        }

        return Integer.parseInt(binNum.toString(), 2);
        // Time: O(n)
        // Space: O(1)
    }

    public int getDecimalValueTwo(ListNode head) {
        int num = 0;
        if (head == null) {
            return num;
        }
        while (head != null) {
            num = num * 2 + head.val;
            head = head.next;
        }
        return num;
        // Time: O(n)
        // Space: O(1)
    }

    class ListNode {
        public int val;
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
