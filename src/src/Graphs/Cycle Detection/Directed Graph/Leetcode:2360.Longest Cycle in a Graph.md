```java
class Solution {
    // DFS to detect and measure cycles in the graph
    public void DFS(int[] edges, int u, boolean[] visited, boolean[] inRecursion, int[] count, int[] longCycle) {
        // Check if the current node has an outgoing edge
        if (edges[u] != -1) {
            // Mark current node as visited
            visited[u] = true;
            // Mark current node in recursion stack to detect back edges
            inRecursion[u] = true;

            // Get the adjacent node
            int v = edges[u];

            // If adjacent node exists and hasn't been visited
            if (v != -1 && !visited[v]) {
                // Increment count for the next node
                count[v] = count[u] + 1;
                // Recursively explore the adjacent node
                DFS(edges, v, visited, inRecursion, count, longCycle);
            } 
            // If adjacent node is already in recursion stack (back edge found)
            else if (v != -1 && inRecursion[v]) {
                // Calculate cycle length and update longest cycle
                longCycle[0] = Math.max(longCycle[0], (count[u] - count[v] + 1));
            }
        }
        // Backtrack: remove current node from recursion stack
        inRecursion[u] = false;
    }

    public int longestCycle(int[] edges) {
        // Total number of vertices
        int V = edges.length;

        // Track visited nodes
        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // Track nodes in current recursion stack
        boolean[] inRecursion = new boolean[V];
        Arrays.fill(inRecursion, false);

        // Count node depths in DFS traversal
        int[] count = new int[V];
        Arrays.fill(count, 1); // Start count always begins at 1

        // Store the length of longest cycle found
        int[] longCycle = {-1};

        // Explore each unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                DFS(edges, i, visited, inRecursion, count, longCycle);
            }
        }

        // Return longest cycle length (or -1 if no cycle)
        return longCycle[0];
    }
}
```
