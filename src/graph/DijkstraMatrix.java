package graph;

import java.util.PriorityQueue;

public class DijkstraMatrix {
    class Solution
    {
        //Function to return the minimum cost to react at bottom
        //right cell from top left cell.
        public int minimumCostPath(int[][] grid)
        {
            // Code here
            int m = grid.length;
            int n = grid[0].length;
            PriorityQueue<Node> q = new PriorityQueue<Node>((a, b) -> a.dist - b.dist);
            int[][] dist = new int[m][n];
            boolean[][] vis = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
            int[] dx = {-1, 0, 0, 1};
            int[] dy = {0, -1, 1, 0};
            q.offer(new Node(0, 0, grid[0][0]));
            dist[0][0] = grid[0][0];
            while (!q.isEmpty()) {
                Node node = q.poll();
                if (vis[node.x][node.y] == true) {
                    continue;
                }
                vis[node.x][node.y] = true;
                for (int a = 0; a < 4; a++) {
                    int newX = node.x + dx[a];
                    int newY = node.y + dy[a];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
                        if (dist[newX][newY] > dist[node.x][node.y] + grid[newX][newY]) {
                            dist[newX][newY] = dist[node.x][node.y] + grid[newX][newY];
                            q.offer(new Node(newX, newY, dist[newX][newY]));
                        }
                    }
                }
            }
            return dist[m-1][n-1];
        }

        class Node {
            int x;
            int y;
            int dist;
            public Node(int x, int y, int dist) {
                this.x = x;
                this.y = y;
                this.dist = dist;
            }
        }
    }
}
