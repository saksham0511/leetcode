package linkedlist;

public class ReverseLinkedListII {
    public static void main(String[] strings) {
        ListNode node = new ListNode();
    }
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    static class Solution {
        public ListNode reverseBetween(ListNode head, int left, int right) {
            ListNode dummy = new ListNode();
            dummy.next = head;

            // temp will be the node before the "left" node. That is, the node just before rotation.
            // Its next is pointing to the future tail of the reversed list. (left node becomes the right most node)
            // Then from this right most node, we can point towards the node that was on the "initial right node + 1"
            ListNode temp = dummy;
            for (int i = 0; i<left-1; i++) {
                temp = temp.next;
            }

            ListNode prev = temp;
            ListNode curr = temp.next;

            for (int i = 0; i < right - left + 1; i++) {
                ListNode t = curr.next;
                curr.next = prev;
                prev = curr;
                curr = t;
            }
            // Lastly the curr becomes the right + 1 node, and prev becomes right node (the head of the reversed part)

            temp.next.next = curr;
            temp.next = prev;

            return dummy.next;
        }
    }
}
