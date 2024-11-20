# DFS
```java
// Solution class containing the logic for detecting a cycle in a directed graph
class Solution {

    // Helper function for Depth First Search (DFS) to detect a cycle
    public boolean DFS(Map<Integer, List<Integer>> adjList, int u, Set<Integer> visited, Set<Integer> inRecursion) {
        visited.add(u); // Mark the current node as visited
        inRecursion.add(u); // Add the node to the recursion stack

        // Traverse all neighbors of the current node
        if (adjList.get(u) != null) {
            for (int v : adjList.get(u)) {
                // If the neighbor is not visited, perform DFS on it
                if (!visited.contains(v) && DFS(adjList, v, visited, inRecursion)) 
                    return true; // Cycle detected
                
                // If the neighbor is already in the recursion stack, it's a cycle
                else if (inRecursion.contains(v)) 
                    return true; // Cycle detected
            }
        }

        inRecursion.remove(u); // Remove the current node from the recursion stack
        return false; // No cycle detected
    }

    // Function to detect a cycle in a directed graph
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Create a HashMap to represent the adjacency list for the graph
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adjList.put(i, new ArrayList<>(adj.get(i))); // Copy adjacency list
        }

        // Sets to keep track of visited nodes and nodes in the recursion stack
        Set<Integer> visited = new HashSet<>();
        Set<Integer> inRecursion = new HashSet<>();

        // Perform DFS from every vertex to check for cycles
        for (int i = 0; i < V; i++) {
            if (!visited.contains(i) && DFS(adjList, i, visited, inRecursion)) {
                return true; // Cycle detected
            }
        }
        return false; // No cycle detected
    }
}
```
# BFS (kahn's Algorithm)
```java
class Solution {

    // Function to detect cycle in a directed graph using Kahn's Algorithm (Topological Sort)
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // Step 1: Convert the input adjacency list to a map for easier access
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adjList.put(i, new ArrayList<>(adj.get(i)));
        }

        // Step 2: Calculate in-degrees of all vertices
        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            if (adjList.get(i) != null) { // Check if the vertex has outgoing edges
                for (int v : adjList.get(i)) {
                    inDegree[v]++; // Increment the in-degree of the target vertex
                }
            }
        }

        // Step 3: Initialize a queue with vertices having in-degree of 0
        Queue<Integer> queue = new LinkedList<>();
        int count = 0; // Count of vertices processed
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) { // Vertex with no incoming edges
                queue.add(i);
                count++; // Increment count as this vertex is processed
            }
        }

        // Step 4: Process the vertices in the queue
        while (!queue.isEmpty()) {
            int u = queue.poll(); // Remove a vertex from the queue

            if (adjList.get(u) != null) { // Check if the vertex has outgoing edges
                for (int v : adjList.get(u)) {
                    inDegree[v]--; // Decrease the in-degree of the neighboring vertex

                    if (inDegree[v] == 0) { // If in-degree becomes 0, add to the queue
                        count++; // Increment count as this vertex will be processed
                        queue.add(v);
                    }
                }
            }
        }

        // Step 5: Check if all vertices were processed
        // If the count equals the total number of vertices, the graph is acyclic
        return count == V ? false : true; // Return true if a cycle is detected, false otherwise
    }
}

```
