package dp;

import java.util.Arrays;

public class ReducingDishes {
    // Either you take the current dish or you do not. If you take the dish, the time increases.
    // Else the time will be taken for whenever you include the next dish.
    class Solution {
        Integer[][] dp;

        public int maxSatisfaction(int[] satisfaction) {
            int n = satisfaction.length;
            Arrays.sort(satisfaction);
            dp = new Integer[n][n];
            return recur(satisfaction, 0, 0);
        }

        public int recur(int[] satisfaction, int time, int i) {
            if (i == satisfaction.length) {
                return 0;
            }
            if (dp[time][i] != null) {
                return dp[time][i];
            }
            int ans = 0;
            ans = Math.max(satisfaction[i]*(time+1) + recur(satisfaction, time+1, i+1), recur(satisfaction, time, i+1));
            dp[time][i] = ans;
            return dp[time][i];
        }
    }
}
