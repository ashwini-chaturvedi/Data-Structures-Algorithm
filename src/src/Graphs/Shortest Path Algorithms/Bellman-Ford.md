# Use When there is negative edge weight and Negative Cycle 
# It is a Successor of Dijkstra because Dijkstra can't detect negative cycle so this.
```java
 public int[] bellmanFord(int n, int[][] edges, int src) {
        // Step 1: Initialize distances from the source to all other nodes as infinity
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0; // Distance to the source is 0

        // Step 2: Relax all edges (n - 1) times
        for (int i = 1; i <= n - 1; i++) { // Relaxation loop
            for (int[] edge : edges) {
                int u = edge[0]; // Start node
                int v = edge[1]; // End node
                int weight = edge[2]; // Edge weight

                if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                    distance[v] = distance[u] + weight; // Relax the edge
                }
            }
        }

        // Step 3: Check for negative weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            if (distance[u] != Integer.MAX_VALUE && distance[u] + weight < distance[v]) {
                System.out.println("Graph contains a negative weight cycle");
                return;
            }
        }
        return distance;
}
```
