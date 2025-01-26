package heap;

import java.util.PriorityQueue;

public class MaximumEatenApples {
    class Solution {
        public int eatenApples(int[] apples, int[] days) {
            PriorityQueue<Node> heap = new PriorityQueue<>((a, b) -> a.day - b.day);
            int ans = 0;
            int i = 0;
            for (i = 0; i < apples.length; i++) {
                if (apples[i] > 0 && days[i] > 0) {
                    heap.offer(new Node(apples[i], i + days[i]));
                }
                while (!heap.isEmpty() && heap.peek().day <= i) {
                    heap.poll();
                }
                Node temp = heap.poll();
                if (temp != null) {
                    ans += 1;
                    temp.apples -= 1;
                    if (temp.apples > 0) {
                        heap.offer(temp);
                    }
                }
            }
            while (!heap.isEmpty()) {
                Node temp = heap.poll();
                if (temp.day > i) {
                    ans += Math.min(temp.apples, temp.day - i);
                    i += Math.min(temp.apples, temp.day - i);
                }
            }
            return ans;
        }

        class Node {
            int apples;
            int day;
            public Node(int apples, int day) {
                this.apples = apples;
                this.day = day;
            }
        }
    }
}
