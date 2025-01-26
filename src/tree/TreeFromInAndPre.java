package tree;

import java.util.HashMap;
import java.util.Map;

public class TreeFromInAndPre {
    class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val) {
            this.val = val;
        }

    }
    class Solution {
        int pre = 0;
        Map<Integer, Integer> hash = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            int n = preorder.length;
            for (int i = 0; i < n; i++) {
                hash.put(inorder[i], i);
            }
            return recur(preorder, inorder, 0, n-1);
        }

        // Since we are travelling in the recursion in preorder itself, we will be travelling the preorder array from left to right only in this function
        // Hence we are only keeping a "pre" value, which can be incremented as we go deeper into the recursion stack.
        // Similarly, if post and inorder were given, we could have traversed the postorder array from back, and in recursion, we would have NRL order. (reverse of post order)
        public TreeNode recur(int[] preorder, int[] inorder, int s, int e) {
            if (s > e) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[pre]);
            pre += 1;
            int index = hash.get(root.val);
            root.left = recur(preorder, inorder, s, index-1);
            root.right = recur(preorder, inorder, index+1, e);
            return root;
        }
    }
}
