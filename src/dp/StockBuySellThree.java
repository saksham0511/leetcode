package dp;

import java.util.ArrayList;
import java.util.List;

public class StockBuySellThree {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome!");
        int[] array = new int[]{3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(Solution.maxProfit(1, array));


    }
    static class Solution {
        static Integer[][][] dp;
        static int n;
        public static int maxProfit(int k, int[] prices) {
            n = prices.length;
            dp = new Integer[2][k+1][n];
            return recur(prices, 0, k, 0);
        }

        private static int recur(int[] prices, int buy, int transactions, int day) {
            if (day >= n || transactions == 0) {
                return 0;
            }
            if (dp[buy][transactions][day] != null) {
                return dp[buy][transactions][day];
            }

            if (buy == 0) {
                dp[buy][transactions][day] = Math.max(recur(prices, 0, transactions, day+1), -prices[day] + recur(prices, 1, transactions, day+1));
            } else {
                dp[buy][transactions][day] = Math.max(recur(prices, 1, transactions, day+1), prices[day] + recur(prices, 0, transactions-1, day+1));
            }
            return dp[buy][transactions][day];
        }
    }
}
