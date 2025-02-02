package heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 1. Sort the pairs on the basis of efficiency. (max to min) This way, we do not need to store Pair in heap, as the next element will always keep the track of the efficiency to be used.
// 2. Now we are already taking the players with max efficiency, the only thing to compromise on is speed
// 3. If some other player in the sorted array has better speed, and popping the one on team currently with min speed
//    gives better result, we should take this new guy in, and remove the other with lesser speed.
// 4. Can only remove from the team on the basis of speed, as the efficiency is already maximum for the team.
public class MaximumPerformaceOfTeam {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int ans = solution.maxPerformance(3, new int[]{2,8,2}, new int[]{2,7,1}, 2);
        System.out.print(ans);
    }
}

class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        List<Pair> pairs = new ArrayList<>();
        PriorityQueue<Integer> speedMinHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pairs.add(new Pair(speed[i], efficiency[i]));
        }
        pairs.sort((a, b) -> Integer.compare(b.eff, a.eff));
        long sum = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (speedMinHeap.size() == k) {
                sum -= speedMinHeap.poll();
            }
            speedMinHeap.offer(pairs.get(i).speed);
            sum += pairs.get(i).speed;
            ans = Math.max(ans, sum*pairs.get(i).eff);
        }
        return (int) (ans % (int) (1e9+7));
    }

    class Pair {
        int speed;
        int eff;
        public Pair(int speed, int eff) {
            this.speed = speed;
            this.eff = eff;
        }
    }
}
