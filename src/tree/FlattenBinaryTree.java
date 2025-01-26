package tree;

public class FlattenBinaryTree {
    class TreeNode {
        TreeNode left;
        TreeNode right;
    }
    class Solution {
        public void flatten(TreeNode root) {
            recur(root);
        }

        public TreeNode recur(TreeNode root) {
            if (root == null) {
                return null;
            }
            // Keep the tail or the leaf node of the subtree being processed
            if (root.right == null && root.left == null) {
                return root;
            }

            // Get the tail of the left and right subtree. left subtrees tail will take the right head
            // Return right tail in the end if not null
            TreeNode left = recur(root.left);
            TreeNode right = recur(root.right);
            if (left != null) {
                TreeNode temp = root.right;
                root.right = root.left;
                root.left = null;
                left.right = temp;
            }
            return right != null ? right : left;
        }
    }
}
