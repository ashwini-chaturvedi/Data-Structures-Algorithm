/* 
                                            Approach:
  1.currentShortestPath < target
    if the Shortest Path Exculding the -1 weighted edges is less then the target initially then we can never
    find another Shortest path that is less than the current path even after changing all the -1 edges to
    1 we may get shorter path then the currentShortestPath but it won't be equal to the target.
    Hence, Return Empty Array;
  2.currentShortestPath == target 
    if the currentShortestPath is equal to the target value then mark isMatched true and change all the edges
    having -1 weight to any larger value so that it cannot interfere with our currentFoundShortestPath
  3.currentShortestPath > target
    if the shortestPath achieved is greater then target then there is a chance to get shorter path which 
    is equal to the target So, now we will step by step change the weight of values from -1 to 1 and call
    dijkstra to get the newShortestPath after changing the node and if we get any distance which is less 
    equal to target we can make it equal to target so mark matched true and put the weight of last changed 
    to edge weight to # edgeWeight+=target-newShortesPath # this will cover up the remaining distance
    and will make the new shortestPath equal to target also after this if there are any negative edge weights
    change it to 1.
*/


class pair {
    long v;
    long wt;

    pair(long s, long w) {
        this.v = s;
        this.wt = w;
    }
}

class Solution {
    public static final int LargeVal = (int) 2e9;// Largest Value

    public long dijkstra(int[][] edges, int s, int d, int n) {

      // Making Graph
        Map<Long, List<long[]>> adjList = new HashMap<>();
        for (int[] edge : edges) {
            if (edge[2] != -1) {

                long u = edge[0];
                long v = edge[1];
                long wt = edge[2];

                if (!adjList.containsKey((long) u)) {
                    adjList.put(u, new ArrayList<>());
                }
                adjList.get(u).add(new long[] { v, wt });

                if (!adjList.containsKey((long) v)) {
                    adjList.put(v, new ArrayList<>());
                }
                adjList.get(v).add(new long[] { u, wt });
            }

        }
        // Dijkstra Starts...
        long[] result = new long[n];
        Arrays.fill(result, Long.MAX_VALUE);
        result[s] = 0;

        PriorityQueue<pair> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a.wt, b.wt));
        minHeap.add(new pair(s, 0));

        while (!minHeap.isEmpty()) {
            pair curr = minHeap.poll();
            long u = curr.v;
            long wt = curr.wt;
            if (adjList.get(u) != null) {
                for (long[] v : adjList.get(u)) {
                    long adjNode = v[0];
                    long adjWt = v[1];
                    if (result[(int) adjNode] > wt + adjWt) {
                        result[(int) adjNode] = wt + adjWt;
                        minHeap.add(new pair(adjNode, wt + adjWt));
                    }
                }
            }
        }
        return result[d];
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        long shortestPath = dijkstra(edges, source, destination, n);

  // *Step:1    
        if (shortestPath < target) {
            return new int[0][0];
        }

  // *Step:2    
        // if shortesPath matched the target
        boolean isMatched = shortestPath == target;
        if (isMatched) {
            for (int[] edge : edges) {
                if (edge[2] == -1) {
                    edge[2] = LargeVal;
                }
            }
            return edges;
        }

  // *Step:3    
        for (int[] edge : edges) {
            if (edge[2] == -1) {
                edge[2] = isMatched ? LargeVal : 1;// if we have already found the shortest path equal to target then
             // assign the largest value so that in cannot cause any issues with
             // our shortestPath else we will assign 1 lowest possible positive
            // number that can be assigned
                if (!isMatched) {
                    long newShortestPath = dijkstra(edges, source, destination, n);
                    if (newShortestPath <= target) {
                        isMatched = true;
                        edge[2]+=(target-newShortestPath);
                    }
                }

            }
        }
        if(!isMatched){
            return new int[0][0];
        }
        return edges;

    }
}
