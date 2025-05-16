package linkedlist.tuf;

import java.util.HashMap;
import java.util.Map;

// https://takeuforward.org/linked-list/length-of-loop-in-linked-list
public class LengthOfLoop {
    public int length(Node head){
        // brute-force: first if there is loop present then we have to determine the length otherwise 0
        // we can use set or hashmap for it
        if (head == null){
            return 0;
        }
        // we have to check if there is a loop present or not and the starting node of the loop
        boolean isLoopPresent = false;
        Node temp = head;
        Node start = null; // assign start of the loop
        int count = 0; // for keep count of nodes
        Map<Node, Integer> map = new HashMap<>();

        while (temp != null){
            if (map.containsKey(temp)){
                isLoopPresent = true;
                start = temp;
                break;
            }
            map.put(temp, ++count);
            temp = temp.next;
        }

        // if there is no loop
        if (!isLoopPresent){
            return 0;
        }

        // now we have to calculate how many nodes are not present in the cycle from the entire LL
//        temp = head;
//        int except = 0;
//        while (temp != start){
//            except++;
//            temp = temp.next;
//        }
//
//        return count - except;
        // instead of above operation to find except, we can do like, as start is begin of cycle and it has value of its number
        return count - map.get(start) - 1;
        // time: O(n)
        // space: O(n)
    }

    public int lengthTwo(Node head){
        // optimal: using slow and fast pointer
        if (head == null){
            return 0;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                break;
            }
        }
        // no cycle
        if (fast == null || fast.next == null){
            return 0;
        }

        int count = 0;

        do {
            count++;
            slow = slow.next;
        } while (slow != fast);

        return count;
        // time: O(n)
        // space: O(1)
    }

    class Node {
        // Data stored in the node
        int data;
        // Pointer to the next node in the list
        Node next;

        // Constructor with both data
        // and next node as parameters
        Node(int data1, Node next1) {
            data = data1;
            next = next1;
        }

        // Constructor with only data as
        // a parameter, sets next to null
        Node(int data1) {
            data = data1;
            next = null;
        }
    }
}
