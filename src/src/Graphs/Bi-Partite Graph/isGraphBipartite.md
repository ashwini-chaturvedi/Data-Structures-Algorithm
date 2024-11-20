```java
class Solution {

    // DFS function to check if the graph can be bipartite
    public boolean DFS(Map<Integer, List<Integer>> adjList, int currNode, int[] colors, int currColor) {
        // Assign the current color to the node
        colors[currNode] = currColor;

        // Check all the adjacent nodes (neighbors) of the current node
        if (adjList.get(currNode) != null) {
            for (int v : adjList.get(currNode)) {
                // If the neighbor has the same color as the current node, it is not bipartite
                if (colors[currNode] == colors[v]) return false;

                // If the neighbor has not been colored yet (color is 0), assign the opposite color and recurse
                if (colors[v] == 0 && !DFS(adjList, v, colors, -currColor)) return false;
            }
        }
        // If no conflicts are found, return true (node can be part of the bipartite graph)
        return true;
    }

    // Function to determine if the graph is bipartite
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        
        // Create an adjacency list from the input graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
            for (int j : graph[i]) {
                adjList.get(i).add(j);
            }
        }

        // Array to store the colors of each node (0 = not colored, 1 = red, -1 = green)
        int[] colors = new int[graph.length];
        
        // Iterate through each node in the graph
        for (int i = 0; i < graph.length; i++) {
            // If the node hasn't been colored yet, start DFS to color it
            if (colors[i] == 0) {
                if (!DFS(adjList, i, colors, 1)) return false;
            }
        }
        
        // If we successfully color the graph with two colors, return true (the graph is bipartite)
        return true;
    }
}

```
