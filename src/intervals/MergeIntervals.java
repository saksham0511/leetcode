package intervals;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {
    public static void main() {

    }
    class Pair {
        int start;
        int end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    class Solution {
        public int[][] merge(int[][] intervals) {
            List<Pair> list = new ArrayList<>();
            int n = intervals.length;
            for (int i = 0; i<n; i++) {
                list.add(new Pair(intervals[i][0], intervals[i][1]));
            }
            list.sort((a,b) -> {
                if (a.start == b.start) {
                    return a.end - b.end;
                }
                return a.start - b.start;
            });
            Integer end = list.get(0).end;
            Integer start = list.get(0).start;
            List<Pair> ans = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                if (end < list.get(i).start) {
                    ans.add(new Pair(start, end));
                    end = list.get(i).end;
                    start = list.get(i).start;
                }
                else {
                    end = Math.max(end, list.get(i).end);
                    start = Math.min(start, list.get(i).start);
                }
            }
            ans.add(new Pair(start, end));
            int[][] arr = new int[ans.size()][2];
            for (int i = 0; i < ans.size() ; i++) {
                arr[i][0] = ans.get(i).start;
                arr[i][1] = ans.get(i).end;
            }
            return arr;
        }

        class Pair {
            int start;
            int end;
            public Pair(int start, int end) {
                this.start = start;
                this.end = end;
            }
        }
    }
}
