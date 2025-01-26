package intervals;

import java.util.Arrays;

public class BurstBalloons {
    class Solution {
        public int findMinArrowShots(int[][] points) {
            int n = points.length;
            int ans = 1;
            Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
            int start = points[0][0];
            int end = points[0][1];
            for (int i = 0; i < n; i++) {
                if (start < points[i][0]) {
                    start = points[i][0];
                }
                if (end > points[i][1]) {
                    end = points[i][1];
                }
                if (end < points[i][0]) {
                    ans += 1;
                    start = points[i][0];
                    end = points[i][1];
                }
            }
            return ans;
        }
    }
}
