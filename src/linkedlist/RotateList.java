package linkedlist;

public class RotateList {
    class ListNode {
        ListNode next;
    }
    class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            int n = length(head);
            if (n == 0) {
                return head;
            }
            k = k % n;
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode fast = dummy;
            ListNode slow = dummy;
            for (int i = 0; i < k; i++) {
                fast = fast.next;
            }
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }
            fast.next = dummy.next;
            dummy.next = slow.next;
            slow.next = null;
            return dummy.next;
        }

        private int length(ListNode head) {
            int count = 0;
            while (head != null) {
                count += 1;
                head = head.next;
            }
            return count;
        }
    }
}
