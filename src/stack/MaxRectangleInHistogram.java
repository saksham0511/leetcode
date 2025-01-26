package stack;

import java.util.Stack;

public class MaxRectangleInHistogram {
    class Solution {
        public int largestRectangleArea(int[] heights) {
            Stack<Integer> stack = new Stack<>();
            stack.push(-1);
            int n = heights.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int top = stack.peek();
                while (top != -1 && heights[top] > heights[i]) {
                    stack.pop();
                    ans = Math.max(ans, heights[top] * (i-stack.peek()-1));
                    top = stack.peek();
                }
                stack.push(i);
            }
            while (stack.peek() != -1){
                int top = stack.pop();
                ans = Math.max(ans, heights[top] * (n-1-stack.peek()));
            }
            return ans;
        }
    }
}
