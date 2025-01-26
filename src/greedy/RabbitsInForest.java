package greedy;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    class Solution {
        public int numRabbits(int[] answers) {
            Map<Integer, Integer> map = new HashMap<>();
            int ans = 0;
            for (int i = 0; i < answers.length; i++) {
                int count = map.getOrDefault(answers[i], 0);
                count += 1;
                if (count == 1) {
                    ans += answers[i] + 1;
                }
                if (count == answers[i] + 1) {
                    map.put(answers[i], 0);
                } else {
                    map.put(answers[i], count);
                }
            }
            return ans;
        }
    }
}
