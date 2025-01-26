package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinWindowSubstring {
    class Solution {
        public String minWindow(String s, String t) {
            int m = s.length();
            int n = t.length();
            Map<Character, Integer> map = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
            }
            int ansStart = Integer.MIN_VALUE;
            int ansEnd = Integer.MAX_VALUE;
            int start = 0;
            int end = 0;
            int count = 0;
            while (end < m) {
                map2.put(s.charAt(end), map2.getOrDefault(s.charAt(end),0)+1);
                if (map.getOrDefault(s.charAt(end), 0)>=map2.get(s.charAt(end))) {
                    count += 1;
                }
                if (count == n) {
                    while (count == n) {
                        if (ansStart == Integer.MIN_VALUE || end - start - 1 < ansEnd - ansStart - 1) {
                            ansEnd = end;
                            ansStart = start;
                        }
                        map2.put(s.charAt(start), map2.get(s.charAt(start))-1);
                        if (map2.get(s.charAt(start)) < map.getOrDefault(s.charAt(start), 0)) {
                            count -= 1;
                        }
                        start += 1;
                    }
                }
                end += 1;
            }
            return ansStart != Integer.MIN_VALUE ? s.substring(ansStart, ansEnd+1) : "";
        }
    }
}
