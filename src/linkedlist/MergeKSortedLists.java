package linkedlist;

public class MergeKSortedLists {
    class ListNode {
        int val;
        ListNode next;
    }
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int n = lists.length;
            return helper(lists, 0, n-1);
        }

        private ListNode helper(ListNode[] lists, int start, int end) {
            if (start > end) {
                return null;
            }
            if (start == end) {
                return lists[start];
            }
            int mid = start + (end-start)/2;
            ListNode left = helper(lists, start, mid);
            ListNode right = helper(lists, mid+1, end);

            return merge(left, right);
        }

        private ListNode merge(ListNode left, ListNode right) {
            ListNode dummy = new ListNode();
            ListNode head = dummy;
            while (left != null && right != null) {
                if (left.val < right.val) {
                    head.next = left;
                    left = left.next;
                    head = head.next;
                } else {
                    head.next = right;
                    right = right.next;
                    head = head.next;
                }
            }
            if (left != null) {
                head.next = left;
            }
            if (right != null) {
                head.next = right;
            }
            return dummy.next;
        }
    }
}
