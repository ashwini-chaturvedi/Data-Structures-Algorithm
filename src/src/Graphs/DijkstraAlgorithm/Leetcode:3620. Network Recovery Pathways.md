# Binary Search on Answer + Shortest Path

You are given a directed acyclic graph of n nodes numbered from 0 to n − 1. This is represented by a 2D array edges of length m, where edges[i] = [ui, vi, costi] indicates a one‑way communication from node ui to node vi with a recovery cost of costi.

Some nodes may be offline. You are given a boolean array online where online[i] = true means node i is online. Nodes 0 and n − 1 are always online.

A path from 0 to n − 1 is valid if:

All intermediate nodes on the path are online.
The total recovery cost of all edges on the path does not exceed k.
For each valid path, define its score as the minimum edge‑cost along that path.

Return the maximum path score (i.e., the largest minimum-edge cost) among all valid paths. If no valid path exists, return -1.

 

Example 1:

Input: edges = [[0,1,5],[1,3,10],[0,2,3],[2,3,4]], online = [true,true,true,true], k = 10

Output: 3

Explanation:

![img](https://assets.leetcode.com/uploads/2025/06/06/graph-10.png)



The graph has two possible routes from node 0 to node 3:

Path 0 → 1 → 3

Total cost = 5 + 10 = 15, which exceeds k (15 > 10), so this path is invalid.

Path 0 → 2 → 3

Total cost = 3 + 4 = 7 <= k, so this path is valid.

The minimum edge‐cost along this path is min(3, 4) = 3.

There are no other valid paths. Hence, the maximum among all valid path‐scores is 3.

# Identification for Binary Search on Answer: the maximum path score (i.e., the largest minimum-edge cost) means Maximize the Minimum.

## Maximize the Minimum

```java
class Solution {

    public boolean canBeFound(Map<Integer,List<int[]>>adjList, boolean[] online, long k, int mid, int V) {
        PriorityQueue<long[]> minHeap = new PriorityQueue<>(Comparator.comparingLong(a->a[1]));
        minHeap.add(new long[] { 0, 0 });

        long[] result = new long[V];
        Arrays.fill(result, Long.MAX_VALUE);
        result[0] = 0;

        while (!minHeap.isEmpty()) {
            long[] res = minHeap.poll();

            int u = (int)res[0];
            long cost = res[1];

            if(cost>result[u]) continue;//if the cost is already greater then there is no need to explore it

            if (adjList.get(u) != null) {
                for (int[] adjNode : adjList.get(u)) {
                    int v = adjNode[0];
                    int wt = adjNode[1];

                    if(wt<mid) continue;//Check if a particular mid is possible by including only the edges with weights ≥ mid (the current binary‐search pivot).

                    long newCost=wt+cost;
                    if (newCost < result[v]) {
                        result[v] = newCost ;
                        minHeap.add(new long[] { v, newCost });
                    }
                }
            }
        }

        return result[V - 1] <= k;
    }

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int V = online.length;

        Map<Integer, List<int[]>> adjList = new HashMap<>();

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int[] edge : edges) {
            int u=edge[0];
            int v=edge[1];
            int cost = edge[2];

            low = Math.min(low, cost);
            high = Math.max(high, cost);

            if (!online[u]) continue;//if the node is not online then skip it's connection in the Graph

            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(new int[] { v, cost });
        }

        int ans = -1;
        //BS on Ans
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canBeFound(adjList, online, k, mid, V)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}

```
