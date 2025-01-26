package linkedlist;

public class ReverseKNodes {
    class ListNode {
        ListNode next;
    }
    class Solution {
        // When reversing, in the end the prev pointer would point to the new front of the reversed list
        // The last curr would point to the head of the list to be reversed.
        // We are storing the head of the current given list, as it will soon be the tail of the list.
        // This tail would then point to the head of the next list, which is returned by the next recursive call
        public ListNode reverseKGroup(ListNode head, int k) {
            if (!len(head, k)) {
                return head;
            }
            ListNode prev = head;
            ListNode curr = head.next;

            for (int i = 0; i < k-1; i++) {
                if (curr == null) {
                    break;
                }
                ListNode t = curr.next;
                curr.next = prev;
                prev = curr;
                curr = t;
            }

            // head became the tail post reversal.
            head.next = null;
            if (curr != null) {
                // curr is in the front of the next group of "k" nodes. It will become the tail eventually there.
                // reverseKGroup() will give us the head of the next list.
                head.next = reverseKGroup(curr, k);
            }
            return prev;
        }

        private boolean len(ListNode head, int k) {
            while (head != null) {
                if (k == 0) {
                    break;
                }
                k = k-1;
                head = head.next;
            }
            return k==0;
        }
    }
}
