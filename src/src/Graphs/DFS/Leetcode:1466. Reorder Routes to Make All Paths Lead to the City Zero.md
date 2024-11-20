```java
class Solution {

    public void DFS(Map<Integer, List<Integer>> adjList, int source, Set<Integer> visited, int[] changes) {
        if (visited.contains(source)) return;

        visited.add(source);

        if (adjList.get(source) != null) {
            for (int dest : adjList.get(source)) {
                if (!visited.contains(Math.abs(dest))) { //if the destination is in reverse direction that is negative or positive...
                    DFS(adjList, Math.abs(dest), visited, changes);

                    changes[0] += (dest > 0 ? 1 : 0); //if we are moving away from zero which means now we have to reverse this direction and hence we count it...
                }
            }
        }
    }

    public int minReorder(int n, int[][] connections) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        // Construct a bi-directional graph using an adjacency list.
        // Forward edges (original direction) are stored as positive values.
        // Reverse edges (to simulate bi-directionality) are stored as negative values to differentiate them.

        for (int[] connect : connections) {
            adjList.putIfAbsent(connect[0], new ArrayList<>());
            adjList.get(connect[0]).add(connect[1]);

            adjList.putIfAbsent(connect[1], new ArrayList<>());
            adjList.get(connect[1]).add(-connect[0]);
        }
        Set<Integer> visited = new HashSet<>();
        int[] changes = { 0 };
        //when we start from zero we want all the nodes to start pointing towards 0 so now we will check every node that goes towards any other node other that 0 or away fron zero we have to reverse that.so we have to reverse the direction when moving forward...
        DFS(adjList, 0, visited, changes);
        return changes[0];
    }
}

```
