import java.util.*;

class Solution {
    
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Create an adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        // Fill adjacency list from the edges
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        
        // Initialize the distance array
        int[] dist = new int[n];
        Arrays.fill(dist, -1); // Mark all distances as -1 (unreachable)
        dist[src] = 0; // Distance from source to source is 0
        
        // BFS
        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (dist[neighbor] == -1) { // If the neighbor hasn't been visited
                    dist[neighbor] = dist[node] + 1; // Update the distance
                    queue.add(neighbor);
                }
            }
        }
        
        return dist;
    }
}
