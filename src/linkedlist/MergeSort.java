package linkedlist;

import java.util.LinkedList;
import java.util.Queue;

public class MergeSort {
    class ListNode {
        int val;
        ListNode next;
    }
    // Two variations of slow and fast pointer approach.
    // One is rabbit and hare, where fast moves 2 steps, slow moves 1
    // Other is where fast pointer gets a head start before slow can start moving
    class Solution {
        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            ListNode temp = slow.next;
            slow.next = null;
            ListNode left = sortList(head);
            ListNode right = sortList(temp);

            return merge(left, right);
        }

        public ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode();
            ListNode head = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    head.next = left;
                    head = head.next;
                    left = left.next;
                } else {
                    head.next = right;
                    head = head.next;
                    right = right.next;
                }
            }
            if (left != null) {
                head.next = left;
            } else {
                head.next = right;
            }
            return dummy.next;
        }
    }
}
