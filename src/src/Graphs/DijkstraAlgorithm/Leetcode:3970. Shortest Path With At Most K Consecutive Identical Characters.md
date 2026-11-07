# Problem: Minimum Cost Path With Consecutive Character Limit

You are given an integer `n` representing the number of nodes in a directed weighted graph, numbered from `0` to `n - 1`.

This graph is represented by a 2D integer array `edges`, where `edges[i] = [ui, vi, wi]` represents a directed edge from node `ui` to node `vi` with weight `wi`.

You are also given:

- A string `labels` of length `n`, where `labels[i]` is the character assigned to node `i`.
- An integer `k`.

Return the **minimum total edge weight** of a path from node `0` to node `n - 1` such that the concatenation of the labels of the nodes along the path contains at most `k` consecutive identical characters.

If no valid path exists, return `-1`.

**Note:** Nodes and edges may be revisited.

## Examples

### Example 1

**Input:**

```text
n = 3
edges = [[0,1,1],[1,2,1],[0,2,3]]
labels = "aab"
k = 1
```

**Output:**

```text
3
```

**Explanation:**

There are two possible paths from node `0` to node `2`:

1. `0 → 1 → 2`
   - Labels: `"aab"`
   - Contains two consecutive `'a'` characters.
   - Invalid because `k = 1`.

2. `0 → 2`
   - Labels: `"ab"`
   - Contains at most one consecutive identical character.
   - Valid, with total cost `3`.

Therefore, the minimum valid path cost is **3**.

## Constraints

- `1 <= n == labels.length <= 5 * 10^4`
- `0 <= edges.length <= 5 * 10^4`
- `edges[i] == [ui, vi, wi]`
- `0 <= ui, vi <= n - 1`
- `ui != vi`
- `1 <= wi <= 10^4`
- `labels` consists of lowercase English letters.
- `1 <= k <= 50`


```java
class Solution {

    public int dijkstra(Map<Integer, List<int[]>> adjList, int s, int n, String labels, int k) {

        //we are monitoring 2 variables ->node and count of consecutive characters.
        int[][] result = new int[n][k + 1];
        for (int[] res : result) {
            Arrays.fill(res, Integer.MAX_VALUE);
        }
        result[s][1] = 0;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        minHeap.add(new int[] { s, 0, 1 });//storing the node, distance and count of consecutive characters at this point

        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();

            int u = node[0];
            int wt = node[1];
            int consecCount = node[2];

            if(u==n-1) return wt;//found the last node

            if (adjList.get(u) != null) {
                for (int[] adjNode : adjList.get(u)) {
                    int v = adjNode[0];
                    int newWt = adjNode[1];

                    //if current element is same as last so increase the consecutive count else make newConseccount=1
                    int newConsecCount = labels.charAt(v) == labels.charAt(u) ? consecCount + 1 : 1;

                    if(newConsecCount>k) continue;//if consecutive count of this node is greater then k then no point of traversing it so leave it.

                    if (result[v][newConsecCount] > wt + newWt ) {
                        result[v][newConsecCount] = wt + newWt;
                        minHeap.add(new int[] { v, wt + newWt, newConsecCount });
                    }
                }
            }
        }

        return -1 ;
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(new int[] { v, w });
        }

        return dijkstra(adjList, 0, n, labels, k);
    }
}

```
