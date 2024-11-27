# use when you need to find the shortest paths between all pairs of nodes in a graph.
```java
// Step 1: Initialize the grid with distances
        int[][] grid = new int[n][n]; 

        // Initialize the grid with a large value (infinity) for all pairs except self-loops (distance = 0)
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE); // Initialize distances to infinity
            grid[i][i] = 0; // Distance from a node to itself is 0
        }
// Fill in the distances for the given edges (direct connections between nodes)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1]; 
            int wt = edge[2]; // Weight (distance) of the edge

            grid[u][v] = wt; // Distance from u to v
            grid[v][u] = wt; // Distance from v to u (since the graph is undirected)
        }

        // Step 2: Apply the Floyd-Warshall algorithm
        // Update the grid to store the shortest distance between all pairs of nodes
        for (int via = 0; via < n; via++) { // "via" represents the intermediate node
            for (int u = 0; u < n; u++) { // Starting node
                for (int v = 0; v < n; v++) { // Destination node
                    // Check if a path through "via" is shorter than the current path
                    if (grid[u][via] != Integer.MAX_VALUE && grid[via][v] != Integer.MAX_VALUE) {
                        grid[u][v] = Math.min(grid[u][v], grid[u][via] + grid[via][v]);
                    }
                }
            }
        }
```
