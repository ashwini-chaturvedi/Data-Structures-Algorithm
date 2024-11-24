```java
class Solution {

    // Approach: We use the Floyd-Warshall algorithm to find the shortest path between all pairs of cities.
    // Then, for each city, we count the number of cities that are reachable within the given distance threshold.
    // Finally, we return the city with the smallest number of reachable cities (with ties resolved by the largest city index).

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Step 1: Initialize the grid with distances
        int[][] grid = new int[n][n]; // grid[i][j] will store the shortest distance between city i and city j

        // Initialize the grid with a large value (infinity) for all pairs except self-loops (distance = 0)
        for (int i = 0; i < n; i++) {
            Arrays.fill(grid[i], Integer.MAX_VALUE); // Initialize distances to infinity
            grid[i][i] = 0; // Distance from a node to itself is 0
        }

        // Fill in the distances for the given edges (direct connections between cities)
        for (int[] edge : edges) {
            int u = edge[0]; // Starting city
            int v = edge[1]; // Destination city
            int wt = edge[2]; // Weight (distance) of the edge

            grid[u][v] = wt; // Distance from u to v
            grid[v][u] = wt; // Distance from v to u (since the graph is undirected)
        }

        // Step 2: Apply the Floyd-Warshall algorithm
        // Update the grid to store the shortest distance between all pairs of cities
        for (int via = 0; via < n; via++) { // "via" represents the intermediate city
            for (int u = 0; u < n; u++) { // Starting city
                for (int v = 0; v < n; v++) { // Destination city
                    // Check if a path through "via" is shorter than the current path
                    if (grid[u][via] != Integer.MAX_VALUE && grid[via][v] != Integer.MAX_VALUE) {
                        grid[u][v] = Math.min(grid[u][v], grid[u][via] + grid[via][v]);
                    }
                }
            }
        }

        // Step 3: Determine the city with the smallest number of reachable cities
        int minReach = Integer.MAX_VALUE; // Minimum number of reachable cities
        int city = -1; // City with the smallest number of reachable cities (to be determined)

        for (int i = 0; i < n; i++) { // Iterate through all cities
            int inReach = 0; // Count of cities reachable from city i within the distance threshold

            for (int j = 0; j < n; j++) { // Check all other cities
                if (i != j && grid[i][j] <= distanceThreshold) { // If city j is reachable from city i
                    inReach++;
                }
            }

            // Update the result based on the minimum reachable cities
            // In case of a tie (same number of reachable cities), choose the city with the larger index
            if (minReach >= inReach) { // Note: "=" ensures we pick the larger index in case of a tie
                minReach = inReach;
                city = i;
            }
        }

        return city; // Return the city with the smallest number of reachable cities
    }
}

```
