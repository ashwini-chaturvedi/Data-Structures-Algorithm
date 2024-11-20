# DFS
```java
class Solution {

    // Recursive function to perform DFS and detect a cycle in an undirected graph
    public boolean solve(Map<Integer, List<Integer>> adjList, int u, Set<Integer> visited, int parent) {
        // Mark the current node as visited
        visited.add(u);

        // Traverse all adjacent nodes
        if (adjList.get(u) != null) { // Check if the current node has neighbors
            for (int v : adjList.get(u)) {
                if (v == parent) {
                    // Skip the parent node as it does not contribute to a cycle
                    continue;
                }
                if (visited.contains(v)) {
                    // If the adjacent node is already visited, a cycle is detected
                    return true;
                }
                // Recursively visit the adjacent node
                if (solve(adjList, v, visited, u)) {
                    return true;
                }
            }
        }

        // No cycle found for this node
        return false;
    }

    // Function to detect cycle in an undirected graph
    public boolean isCycle(ArrayList<ArrayList<Integer>> adj) {
        // Convert the adjacency list to a map for easier access
        Map<Integer, List<Integer>> adjList = new HashMap<>();

        for (int i = 0; i < adj.size(); i++) {
            adjList.put(i, adj.get(i)); // Populate the map with adjacency lists
        }

        // Set to track visited nodes
        Set<Integer> visited = new HashSet<>();

        // Iterate through all nodes
        for (int i = 0; i < adj.size(); i++) {
            // If the node is not visited, perform DFS to detect a cycle
            if (!visited.contains(i) && solve(adjList, i, visited, -1)) {
                return true; // Cycle detected
            }
        }

        // No cycle detected in the graph
        return false;
    }
}

```
# BFS
```java
class Solution {
    
    // Function to perform BFS and detect a cycle in an undirected graph
    public boolean BFS(Map<Integer, ArrayList<Integer>> adjList, int u, Set<Integer> visited) {
        // Queue to store nodes along with their parent information
        Queue<int[]> q = new LinkedList<>();
        // Mark the starting node as visited
        visited.add(u);
        // Add the starting node to the queue with parent set to -1 (indicating no parent)
        q.add(new int[] { u, -1 });
        
        while (!q.isEmpty()) {
            // Dequeue the front node
            int[] num = q.poll();
            int child = num[0];
            int parent = num[1];
            
            // Iterate through all neighbors of the current node
            if (adjList.get(child) != null) { // Check if the node has any neighbors
                for (int v : adjList.get(child)) {
                    if (!visited.contains(v)) {
                        // If the neighbor is not visited, mark it as visited and enqueue it
                        visited.add(v);
                        q.add(new int[] { v, child });
                    } else if (visited.contains(v) && parent != v) {
                        // If the neighbor is visited and it's not the parent, a cycle is detected
                        return true;
                    }
                }
            }
        }
        // No cycle detected
        return false;
    }

    // Function to detect cycle in an undirected graph
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Convert adjacency list to a map for easier manipulation
        Map<Integer, ArrayList<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < V; i++) {
            adjList.put(i, new ArrayList<>(adj.get(i)));
        }
        
        // Set to track visited nodes
        Set<Integer> visited = new HashSet<>();
        
        // Loop through all nodes (to handle disconnected graphs)
        for (int i = 0; i < V; i++) {
            // If the node is not visited, perform BFS to detect a cycle
            if (!visited.contains(i) && BFS(adjList, i, visited)) {
                return true; // Cycle detected
            }
        }
        // No cycle detected in the graph
        return false;
    }
}

```
