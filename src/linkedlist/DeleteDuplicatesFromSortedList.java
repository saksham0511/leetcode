package linkedlist;

public class DeleteDuplicatesFromSortedList {
    class ListNode {
        ListNode next;
        int val;
    }
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode prev = dummy;
            ListNode curr = head;
            while (curr != null && curr.next != null) {
                if (curr.val == curr.next.val) {
                    int val = curr.val;
                    while (curr != null && curr.val == val) {
                        curr = curr.next;
                    }
                    prev.next = curr;
                } else {
                    prev = curr;
                    curr = curr.next;
                }
            }
            return dummy.next;
        }
    }
}
