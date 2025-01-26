package tree;

import java.util.ArrayList;
import java.util.List;

public class MaxSumNonAdjacentNodes {
    class Node {
        int data;
        Node right;
        Node left;
    }
    class Solution
    {
        //Function to return the maximum sum of non-adjacent nodes.
        static int getMaxSum(Node root)
        {
            // add your code here
            List<Integer> ans = helper(root);
            return Math.max(ans.get(0), ans.get(1));
        }

        // dp -> non adjacent element sum f(n) = max(element[n] + f(n-2), f(n-1))
        private static List<Integer> helper(Node root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null) {
                ans.add(0);
                ans.add(0);
                return ans;
            }
            List<Integer> left = helper(root.left);
            List<Integer> right = helper(root.right);

            int non = root.data + left.get(1) + right.get(1);
            int ad = left.get(0) + right.get(0);
            ans.add(Math.max(non, ad));
            ans.add(ad);
            return ans;
        }
    }
}
