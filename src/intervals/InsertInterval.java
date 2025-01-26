package intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    class Solution {
        public int[][] insert(int[][] intervals, int[] newInterval) {
            int n = intervals.length;
            List<List<Integer>> ans = new ArrayList<>();
            int i = 0;
            boolean inserted = false;
            while (i < n) {
                if (!inserted && ((newInterval[0] <= intervals[i][1] && newInterval[1] >= intervals[i][0]) ||
                        (newInterval[0] < intervals[i][0] && newInterval[1] < intervals[i][0]))) {
                    int start = newInterval[0];
                    int end = newInterval[1];
                    while (i < n && newInterval[0] <= intervals[i][1] && newInterval[1] >= intervals[i][0]) {
                        start = Math.min(start, intervals[i][0]);
                        end = Math.max(end, intervals[i][1]);
                        i++;
                    }
                    ans.add(Arrays.asList(start, end));
                    inserted = true;
                } else {
                    ans.add(Arrays.asList(intervals[i][0], intervals[i][1]));
                    i++;
                }
            }
            if (!inserted) {
                ans.add(Arrays.asList(newInterval[0], newInterval[1]));
            }
            int[][] arr = new int[ans.size()][2];
            for (i = 0; i < ans.size(); i++) {
                arr[i][0] = ans.get(i).get(0);
                arr[i][1] = ans.get(i).get(1);
            }
            return arr;
        }
    }
}
