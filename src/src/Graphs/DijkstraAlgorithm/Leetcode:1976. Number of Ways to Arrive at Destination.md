# Calculating the Number of ways to Reach the Node with same Shortest Distance...
```java
class Pair {
    int u;
    long wt;

    Pair(int v, long w) {
        u = v;
        wt = w;
    }
}

class Solution {

    public int Dijkstra(Map<Integer, List<Pair>> adjList, int n) {
        int mod = (int) (1e9 + 7);

        long[] result = new long[n];
        Arrays.fill(result, Long.MAX_VALUE);
        result[0] = 0;

        //To Store the Number of Ways to reach the node from 0
        int[] ways = new int[n];
        ways[0] = 1;//Number of ways to reach source that is 0 is 1

        PriorityQueue<Pair> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a.wt,b.wt));
        minHeap.add(new Pair(0, 0));

        while (!minHeap.isEmpty()) {
            Pair curr = minHeap.poll();
            int u = curr.u;
            long wt = curr.wt;

            if (adjList.get(u) != null) {
                for (Pair v : adjList.get(u)) {
                    int adjNode = v.u;
                    long adjWt = v.wt;

                    if (result[adjNode] > wt + adjWt) {//To find the Shortest Path
                        result[adjNode] = wt + adjWt;
                        ways[adjNode] = ways[u];//Found the Shortest path to reach the Node so the number of ways to reach this node is by its parent node or its previous node so number of ways will be same as the Parent Node. 
                        minHeap.add(new Pair(adjNode, wt + adjWt));
                    } else if (result[adjNode] == wt + adjWt) {//if the Shortest Path is Same and yet we Reached the Node which means that Previously we have reached to this point by any other way with the same shortest Distance so now the total number of ways to reach this node is by adding the ways to reach the current node plus the previous node because some one who reaches the Previous node can reach this node...
                        ways[adjNode] = (ways[adjNode] + ways[u]) % mod;
                    }
                }
            }
        }
        return ways[n - 1] % mod;//Number of Ways to reach the (n-1)th node...
    }

    public int countPaths(int n, int[][] roads) {
        Map<Integer, List<Pair>> adjList = new HashMap<>();

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int wt = road[2];
            adjList.putIfAbsent(u, new ArrayList<>());
            adjList.get(u).add(new Pair(v, wt));

            adjList.putIfAbsent(v, new ArrayList<>());
            adjList.get(v).add(new Pair(u, wt));
        }

        return Dijkstra(adjList, n);
    }
}

```
