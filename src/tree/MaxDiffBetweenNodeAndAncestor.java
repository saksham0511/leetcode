package tree;

public class MaxDiffBetweenNodeAndAncestor {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        Integer ans = Integer.MIN_VALUE;
        public int maxAncestorDiff(TreeNode root) {
            helper(root.left, root.val, root.val);
            helper(root.right, root.val, root.val);
            return ans;
        }

        // The recursion stack will keep the min and max from the current node (since the root) till the end of the path
        // When we go back up the recursion stack (the method that called the current method), it will always have the older min and max value
        private void helper(TreeNode root, int max, int min) {
            if (root == null) {
                return;
            }
            ans = Math.max(Math.abs(max - root.val), ans);
            ans = Math.max(Math.abs(min - root.val), ans);
            helper(root.left, Math.max(max, root.val), Math.min(min, root.val));
            helper(root.right, Math.max(max, root.val), Math.min(min, root.val));
        }
    }
}
