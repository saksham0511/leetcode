package dp;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class WordBreak {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] array = new int[]{2,3,1,1,4};
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");
        System.out.println(Solution.wordBreak(s, list));

    }
    static class Solution {
        static Boolean[] dp;
        public static boolean wordBreak(String s, List<String> wordDict) {
            int n = s.length();
            dp = new Boolean[n];
            return helper(0, s.length(), s, wordDict);
        }

        private static boolean helper(int i, int n, String s, List<String> wordDict) {
            if (i == n) {
                return true;
            }
            if (dp[i] != null) {
                return dp[i];
            }
            boolean ans = false;
            for (int j = i+1; j <= n; j++) {
                if (wordDict.contains(s.substring(i, j))) {
                    ans = ans || helper(j, n, s, wordDict);
                }
            }
            dp[i] = ans;
            return ans;
        }
    }
}